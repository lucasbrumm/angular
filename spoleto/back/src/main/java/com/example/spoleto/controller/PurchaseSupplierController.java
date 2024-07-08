package com.example.spoleto.controller;

import com.example.spoleto.dto.BuyProductStockFromSupplierRequestDTO;
import com.example.spoleto.dto.BuyProductStockFromSupplierResponseDTO;
import com.example.spoleto.model.BuyProductStockFromSupplierResponse;
import com.example.spoleto.service.PurchaseSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase-supplier")
public class PurchaseSupplierController {

    @Autowired
    PurchaseSupplierService purchaseSupplierService;

    @PostMapping("/buy")
    public BuyProductStockFromSupplierResponse buy(@RequestBody BuyProductStockFromSupplierRequestDTO buyProductStockFromSupplierRequestDTO) {
        return purchaseSupplierService.buyFromSupplier(buyProductStockFromSupplierRequestDTO);
    }
}
