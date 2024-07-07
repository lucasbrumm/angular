package com.example.spoleto.controller;

import com.example.spoleto.dto.EditStockRequestDTO;
import com.example.spoleto.dto.SaveProductStockDTO;
import com.example.spoleto.model.Stock;
import com.example.spoleto.model.product.Product;
import com.example.spoleto.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    StockService stockService;

    @GetMapping("/get-all")
    public List<Stock> getAll() {
        return stockService.getAllProductsStock();
    }

    @PostMapping("/save-stock-product")
    public Stock saveProduct(@RequestBody SaveProductStockDTO saveProductStockDTO) {
        return stockService.saveStockProduct(saveProductStockDTO);
    }

    @GetMapping("/{id}")
    public Stock getStock(@PathVariable Long id) {
        return stockService.getProductStockById(id);
    }

    @PostMapping("/edit-cost")
    public Stock editCost(@RequestBody EditStockRequestDTO editStockRequestDTO) {
        return stockService.editCostProductStock(editStockRequestDTO);
    }

    @PostMapping("/decrement")
    public Stock decrementStock(@RequestBody EditStockRequestDTO editStockRequestDTO) {
        return stockService.decrementProductStock(editStockRequestDTO);
    }

    @PostMapping("/increment")
    public Stock incrementStock(@RequestBody EditStockRequestDTO editStockRequestDTO) {
        return stockService.incrementStock(editStockRequestDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable Long id) {
        stockService.deleteProductStock(id);
    }
}
