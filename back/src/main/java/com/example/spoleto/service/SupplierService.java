package com.example.spoleto.service;

import com.example.spoleto.dto.SaveSupplierRequestDTO;
import com.example.spoleto.exception.InvalidValueException;
import com.example.spoleto.exception.NotFoundException;
import com.example.spoleto.model.Supplier;
import com.example.spoleto.model.product.Product;
import com.example.spoleto.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public List<Supplier> getAllSupplier() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Long supplierId) {
        return supplierRepository.findById(supplierId).orElseThrow(() -> new NotFoundException(
                "Supplier with ID " + supplierId + " not found."
        ));
    }

    public Supplier saveSupplier(SaveSupplierRequestDTO saveSupplierRequestDTO) {
        if(saveSupplierRequestDTO.contactNumber() == null || saveSupplierRequestDTO.email() == null ||
            saveSupplierRequestDTO.cnpj() == null) {
            throw new InvalidValueException("Missing Contact Number, Email or CNPJ");
        }

        Supplier newSupplier = new Supplier(saveSupplierRequestDTO);
        Optional<Supplier> optionalSupplier = getOptionalSupplierByCnpj(saveSupplierRequestDTO.cnpj());
        if(optionalSupplier.isPresent()) {
            throw new InvalidValueException("Supplier with CNPJ " + saveSupplierRequestDTO.cnpj() + " has already been registered.");
        }

        supplierRepository.save(newSupplier);
        return newSupplier;
    }

    public Supplier editSupplier() {
        return null;
    }

    public void changeStatusSupplier() {
    }

    private Optional<Supplier> getOptionalSupplierByCnpj(String cnpjSupplier) {
        return supplierRepository.findByCnpj(cnpjSupplier);
    }
}
