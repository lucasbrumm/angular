package com.example.spoleto.service;

import com.example.spoleto.dto.SellProductRequestDTO;
import com.example.spoleto.dto.SellProductResponseDTO;
import com.example.spoleto.exception.InvalidValueException;
import com.example.spoleto.model.OrderClient;
import com.example.spoleto.model.Stock;
import com.example.spoleto.model.Supplier;
import com.example.spoleto.model.enums.OrderStatus;
import com.example.spoleto.model.product.Product;
import com.example.spoleto.model.rel.RelOrderClientProductQuant;
import com.example.spoleto.model.rel.RelPurchaseSupplierStockQuant;
import com.example.spoleto.repository.OrderClientRepository;
import com.example.spoleto.repository.ProductRepository;
import com.example.spoleto.repository.RelOrderClientProductQuantRepository;
import com.example.spoleto.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
public class OrderClientService {
    @Autowired
    OrderClientRepository orderClientRepository;

    @Autowired
    StockService stockService;

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    RelOrderClientProductQuantRepository relOrderClientProductQuantRepository;

    @Transactional
    public SellProductResponseDTO sellForClient(SellProductRequestDTO sellProductRequestDTO) {
        OrderClient orderClient = new OrderClient();
        orderClientRepository.save(orderClient);

        final BigDecimal[] valueTotal = {BigDecimal.ZERO};

        Map<Product, BigDecimal> consolidatedQuantities = new HashMap<>();
        sellProductRequestDTO.productList().forEach(product -> {
            consolidatedQuantities.merge(product.product(), product.quantity(), BigDecimal::add);
        });
        List<RelOrderClientProductQuant> savedRelations = new ArrayList<>();

        consolidatedQuantities.forEach((product, quantity) -> {
            Optional<Product> optionalProduct = getOptionalProduct(product.getId(), null);

            if(optionalProduct.isEmpty()) {
                throw new InvalidValueException("Product with ID " + product.getId() + " not exists");
            }

            RelOrderClientProductQuant rel = new RelOrderClientProductQuant(product,
                    orderClient, quantity);
            relOrderClientProductQuantRepository.save(rel);

            savedRelations.add(rel);
            valueTotal[0] = valueTotal[0].add(product.getPrice().multiply(quantity));
        });

        orderClient.setTotalPrice(valueTotal[0]);
        orderClient.setOrderStatus(OrderStatus.COMPLETED);
        orderClientRepository.save(orderClient);

        return new SellProductResponseDTO(orderClient, savedRelations);
    }

    private Optional<Product> getOptionalProduct(Long id, String name) {
        return id == null ? productRepository.findByName(name) : productRepository.findById(id);
    }
}
