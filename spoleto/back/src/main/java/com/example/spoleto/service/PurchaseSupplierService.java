package com.example.spoleto.service;

import com.example.spoleto.dto.BuyProductStockFromSupplierRequestDTO;
import com.example.spoleto.dto.ChangeStatusPurchaseSupplierRequestDTO;
import com.example.spoleto.exception.InvalidValueException;
import com.example.spoleto.exception.InvalidValueExceptionDB;
import com.example.spoleto.dto.BuyProductStockFromSupplierResponse;
import com.example.spoleto.model.PurchaseSupplier;
import com.example.spoleto.model.Stock;
import com.example.spoleto.model.Supplier;
import com.example.spoleto.model.enums.PurchaseStatus;
import com.example.spoleto.model.rel.RelPurchaseSupplierStockQuant;
import com.example.spoleto.repository.PurchaseSupplierRepository;
import com.example.spoleto.repository.RelPurchaseSupplierStockQuantRepository;
import com.example.spoleto.repository.StockRepository;
import com.example.spoleto.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
public class PurchaseSupplierService {

    @Autowired
    PurchaseSupplierRepository purchaseSupplierRepository;

    @Autowired
    RelPurchaseSupplierStockQuantRepository relPurchaseSupplierStockQuantRepository;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    StockRepository stockRepository;

    @Transactional
    public BuyProductStockFromSupplierResponse buyFromSupplier(BuyProductStockFromSupplierRequestDTO buyProductStockFromSupplierDTO) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(buyProductStockFromSupplierDTO.idSupplier());

        if(optionalSupplier.isEmpty()) {
            throw new InvalidValueException("Supplier with ID " + buyProductStockFromSupplierDTO.idSupplier() +
                    " not exists");
        }

        PurchaseSupplier purchaseSupplier = new PurchaseSupplier(optionalSupplier.get());
        purchaseSupplierRepository.save(purchaseSupplier);

        Map<Long, BigDecimal> consolidatedQuantities = new HashMap<>();
        buyProductStockFromSupplierDTO.purchases().forEach(purchase -> {
            consolidatedQuantities.merge(purchase.productId(), purchase.quantity(), BigDecimal::add);
        });

        List<RelPurchaseSupplierStockQuant> savedRelations = new ArrayList<>();
        final BigDecimal[] valueTotalSupplier = {BigDecimal.ZERO};

        consolidatedQuantities.forEach((productId, quantity) -> {
            Stock stock = stockRepository.findById(productId).orElseThrow();
            RelPurchaseSupplierStockQuant rel = new RelPurchaseSupplierStockQuant(purchaseSupplier, stock, quantity);
            relPurchaseSupplierStockQuantRepository.save(rel);
            savedRelations.add(rel);
             valueTotalSupplier[0] = valueTotalSupplier[0].add(rel.getStock().getCost().multiply(quantity));
        });

        purchaseSupplier.setTotalValue(valueTotalSupplier[0]);
        purchaseSupplierRepository.save(purchaseSupplier);

        return new BuyProductStockFromSupplierResponse(
                purchaseSupplier, savedRelations
        );
    }

    public List<PurchaseSupplier> getAllPurchases() {
        return purchaseSupplierRepository.findAll();
    }

    @Transactional
    public String changeStatusPurchaseSupplier(ChangeStatusPurchaseSupplierRequestDTO
                                                               changeStatusPurchaseSupplierRequestDTO) {
        Optional<PurchaseSupplier> optionalSupplier = purchaseSupplierRepository.
                findById(changeStatusPurchaseSupplierRequestDTO.idSupplierPurchase());

        if(optionalSupplier.isEmpty()) {
            throw new InvalidValueException("Supplier Purchase with ID " +
                    changeStatusPurchaseSupplierRequestDTO.idSupplierPurchase() +
                    " not exists");
        }

        if(optionalSupplier.get().getStatus() == PurchaseStatus.COMPLETED) {
            throw new InvalidValueExceptionDB("Can't change a purchase COMPLETED");
        }

        if(optionalSupplier.get().getStatus() == PurchaseStatus.CANCELLED) {
            throw new InvalidValueExceptionDB("Can't change a purchase CANCELLED");
        }

        PurchaseSupplier purchaseSupplier = optionalSupplier.get();
        purchaseSupplier.setStatus(changeStatusPurchaseSupplierRequestDTO.statusPurchase());
        purchaseSupplierRepository.save(purchaseSupplier);

        var responseQueryStock = stockRepository.findStockInfoByPurchaseSupplierId(purchaseSupplier.getId());

        if(changeStatusPurchaseSupplierRequestDTO.statusPurchase() == PurchaseStatus.COMPLETED &&
                purchaseSupplier.getStatus() == PurchaseStatus.COMPLETED
        ) {
            responseQueryStock.forEach(item -> {
                Stock editStock = stockRepository.findById(item.getStockProductId()).orElseThrow();
                editStock.setQuantity(editStock.getQuantity().add(item.getQuantity()));
                stockRepository.save(editStock);
            });
        }

        return changeStatusPurchaseSupplierRequestDTO.statusPurchase().toString();
    }
}
