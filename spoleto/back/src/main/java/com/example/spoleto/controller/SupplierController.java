package com.example.spoleto.controller;

import com.example.spoleto.dto.ChangeStatusSupplierRequestDTO;
import com.example.spoleto.dto.SaveProductStockDTO;
import com.example.spoleto.dto.SaveSupplierRequestDTO;
import com.example.spoleto.model.Stock;
import com.example.spoleto.model.Supplier;
import com.example.spoleto.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping("/get-all")
    public List<Supplier> getAll() {
        return supplierService.getAllSupplier();
    }

    @GetMapping("/{id}")
    public Supplier getSupplier(@PathVariable Long id) {
        return supplierService.getSupplierById(id);
    }

    @PostMapping("/save")
    public Supplier save(@RequestBody SaveSupplierRequestDTO saveSupplierRequestDTO) {
        return supplierService.saveSupplier(saveSupplierRequestDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/change-status")
    public void changeStatus(@RequestBody ChangeStatusSupplierRequestDTO changeStatusSupplierRequestDTO) {
        supplierService.changeStatusSupplier(changeStatusSupplierRequestDTO);
    }
}
