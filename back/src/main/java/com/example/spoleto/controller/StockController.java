package com.example.spoleto.controller;

import com.example.spoleto.dto.EditStockRequestDTO;
import com.example.spoleto.dto.SaveProductStockDTO;
import com.example.spoleto.model.Product;
import com.example.spoleto.model.Stock;
import com.example.spoleto.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    StockService stockService;

    @GetMapping("/")
    public List<Stock> getAll() {
        return stockService.getAllProductsStock();
    }

    @PostMapping("/save-stock-product")
    public SaveProductStockDTO saveProductStock(@RequestBody SaveProductStockDTO saveProductStockDTO) {
        return stockService.saveStockProduct(saveProductStockDTO);
    }

    @PostMapping("/edit-cost")
    public Stock editCost(@RequestBody EditStockRequestDTO editStockRequestDTO) {
        return stockService.editCostProductStock(editStockRequestDTO);
    }

    @PostMapping("/decrement")
    public Stock decrementStock(@RequestBody EditStockRequestDTO editStockRequestDTO) {
        return stockService.decrementProductStock(editStockRequestDTO);
    }
}
