package com.example.spoleto.controller;

import com.example.spoleto.dto.BuyProductStockFromSupplierRequestDTO;
import com.example.spoleto.dto.BuyProductStockFromSupplierResponseDTO;
import com.example.spoleto.dto.ChangeStatusPurchaseSupplierRequestDTO;
import com.example.spoleto.model.BuyProductStockFromSupplierResponse;
import com.example.spoleto.model.PurchaseSupplier;
import com.example.spoleto.model.enums.PurchaseStatus;
import com.example.spoleto.service.PurchaseSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase-supplier")
public class PurchaseSupplierController {

    @Autowired
    PurchaseSupplierService purchaseSupplierService;

    @PostMapping("/buy")
    public BuyProductStockFromSupplierResponse buy(@RequestBody BuyProductStockFromSupplierRequestDTO buyProductStockFromSupplierRequestDTO) {
        return purchaseSupplierService.buyFromSupplier(buyProductStockFromSupplierRequestDTO);
    }

    @GetMapping("/get-all")
    public List<PurchaseSupplier> getAllPurchaseSupplier() {
        return purchaseSupplierService.getAllPurchases();
    }

    @PostMapping("/change-status")
    public String changeStatus(@RequestBody ChangeStatusPurchaseSupplierRequestDTO
                                                   changeStatusPurchaseSupplierRequestDTO) {
        return purchaseSupplierService.changeStatusPurchaseSupplier(changeStatusPurchaseSupplierRequestDTO);
    }
    
}
