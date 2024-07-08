package com.example.spoleto.controller;

import com.example.spoleto.dto.SellProductRequestDTO;
import com.example.spoleto.dto.SellProductResponseDTO;
import com.example.spoleto.service.OrderClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-client")
public class OrderClientController {
    @Autowired
    OrderClientService orderClientService;

    @PostMapping("/sell")
    private SellProductResponseDTO sell(@RequestBody SellProductRequestDTO sellProductRequestDTO) {
        return orderClientService.sellForClient(sellProductRequestDTO);
    }
}
