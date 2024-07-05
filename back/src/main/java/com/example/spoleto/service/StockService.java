package com.example.spoleto.service;

import com.example.spoleto.dto.SaveProductStockDTO;
import com.example.spoleto.exception.ProductNameAlreadyExistsException;
import com.example.spoleto.model.Product;
import com.example.spoleto.model.Stock;
import com.example.spoleto.repository.ProductRepository;
import com.example.spoleto.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllProductsStock() {
        return stockRepository.findAll();
    }

    public SaveProductStockDTO saveStockProduct(@RequestBody SaveProductStockDTO saveProductStockDTO) {
        if (stockRepository.findByName(saveProductStockDTO.name()).isPresent()) {
            throw new ProductNameAlreadyExistsException("Product in the stock " + saveProductStockDTO.name() + " already exists.");
        }
        Stock newProductStock = new Stock(saveProductStockDTO);
        stockRepository.save(newProductStock);
        return saveProductStockDTO;
    }

//    public Stock editCostProductStock(String) {
//
//    }
}
