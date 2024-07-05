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

    public SaveProductStockDTO saveStockProduct(@RequestBody SaveProductStockDTO saveProductStockDTO) {
        Stock newProductStock = new Stock(saveProductStockDTO);
        stockRepository.save(newProductStock);
        return saveProductStockDTO;
    }

}
