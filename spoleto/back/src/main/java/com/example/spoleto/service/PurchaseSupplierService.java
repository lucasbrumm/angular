package com.example.spoleto.service;

import com.example.spoleto.dto.BuyProductStockFromSupplierRequestDTO;
import com.example.spoleto.dto.BuyProductStockFromSupplierResponseDTO;
import com.example.spoleto.exception.InvalidValueException;
import com.example.spoleto.model.BuyProductStockFromSupplierResponse;
import com.example.spoleto.model.PurchaseSupplier;
import com.example.spoleto.model.Stock;
import com.example.spoleto.model.Supplier;
import com.example.spoleto.model.rel.PurchaseSupplierStockId;
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

        PurchaseSupplier purchaseSupplier = new PurchaseSupplier(buyProductStockFromSupplierDTO, optionalSupplier.get());
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

        BuyProductStockFromSupplierResponse buy = new BuyProductStockFromSupplierResponse(
                purchaseSupplier, savedRelations
        );

        return buy;
    }

    public List<PurchaseSupplier> getAllPurchases() {
        return purchaseSupplierRepository.findAll();
    }
}
