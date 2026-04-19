package com.pedro.efood.controller;

import com.pedro.efood.dto.CheckoutRequestDTO;
import com.pedro.efood.dto.CheckoutResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/checkout")
@CrossOrigin(origins = "*")
public class CheckoutController {

    @PostMapping
    public CheckoutResponseDTO checkout(@RequestBody CheckoutRequestDTO body) {

        // simula criação do pedido
        Long orderId = new Random().nextLong(100000, 999999);

        return new CheckoutResponseDTO(orderId);
    }
}
