package com.example.spoleto.controller;

import com.example.spoleto.dto.SaveProductStockDTO;
import com.example.spoleto.model.Product;
import com.example.spoleto.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    StockService stockService;

    @PostMapping("/save-stock-product")
    public SaveProductStockDTO saveProductStock(@RequestBody SaveProductStockDTO saveProductStockDTO) {
        return stockService.saveStockProduct(saveProductStockDTO);
    }
}
