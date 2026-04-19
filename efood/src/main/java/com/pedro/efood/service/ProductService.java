package com.pedro.efood.service;

import com.pedro.efood.model.Product;
import com.pedro.efood.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findByRestaurant(Long restaurantId) {
        return repository.findByRestaurantId(restaurantId);
    }
}