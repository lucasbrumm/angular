package com.example.spoleto.dto;

import com.example.spoleto.model.enums.ProductType;

public record SaveProductDTO(String name, String price, ProductType productType){
}
