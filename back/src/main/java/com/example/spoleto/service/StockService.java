package com.example.spoleto.service;

import com.example.spoleto.dto.SaveProductStockDTO;
import com.example.spoleto.model.Product;
import com.example.spoleto.model.Stock;
import com.example.spoleto.repository.ProductRepository;
import com.example.spoleto.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductRepository productRepository;

    public SaveProductStockDTO saveStockProduct(@RequestBody SaveProductStockDTO saveProductStockDTO) {
        Product newProduct = new Product(saveProductStockDTO);
        productRepository.save(newProduct);
        Stock newProductStock = new Stock(saveProductStockDTO, newProduct);
        stockRepository.save(newProductStock);
        return saveProductStockDTO;
    }

}
