package com.example.spoleto.service;

import com.example.spoleto.dto.EditStockRequestDTO;
import com.example.spoleto.dto.SaveProductStockDTO;
import com.example.spoleto.exception.InsufficientStockException;
import com.example.spoleto.exception.InvalidValueException;
import com.example.spoleto.exception.ProductNameAlreadyExistsException;
import com.example.spoleto.exception.ProductNotFoundException;
import com.example.spoleto.model.Stock;
import com.example.spoleto.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllProductsStock() {
        return stockRepository.findAll();
    }

    public SaveProductStockDTO saveStockProduct(@RequestBody SaveProductStockDTO saveProductStockDTO) {
        Optional<Stock> optionalStock = getOptionalStockProduct(null, saveProductStockDTO.name());
        if (optionalStock.isPresent()) {
            throw new ProductNameAlreadyExistsException("Product in the stock " + saveProductStockDTO.name() +
                    " already exists.");
        }
        Stock newProductStock = new Stock(saveProductStockDTO);
        stockRepository.save(newProductStock);
        return saveProductStockDTO;
    }

    public Stock editCostProductStock(EditStockRequestDTO editStockRequestDTO) {
        Optional<Stock> optionalStock = getOptionalStockProduct(editStockRequestDTO.id(), null);
        if (optionalStock.isEmpty()) {
            throw new ProductNotFoundException("Product with id " + editStockRequestDTO.id()+ " not exists.");
        }
        if(editStockRequestDTO.value().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidValueException("Invalid value " + editStockRequestDTO.value());
        }

        Stock newCostProductStock = optionalStock.get();
        newCostProductStock.setCost(editStockRequestDTO.value());
        stockRepository.save(newCostProductStock);
        return newCostProductStock;
    }

    public Stock decrementProductStock(EditStockRequestDTO editStockRequestDTO) {
        Optional<Stock> optionalStock = getOptionalStockProduct(editStockRequestDTO.id(), null);
        if(optionalStock.isEmpty()) {
            throw new ProductNotFoundException("Product with id " + editStockRequestDTO.id()+ " not exists.");
        }

        Stock productStock = optionalStock.get();

        if(productStock.getQuantity().subtract(editStockRequestDTO.value()).compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientStockException("Insufficient stock. Requested: " + editStockRequestDTO.value() +
                    ", Available: " + productStock.getQuantity());
        }

        productStock.setQuantity(productStock.getQuantity().subtract(editStockRequestDTO.value()));
        stockRepository.save(productStock);
        return productStock;
    }

    private Optional<Stock> getOptionalStockProduct(Long id, String name) {
        return id == null ? stockRepository.findByName(name) : stockRepository.findById(id);
    }
}
