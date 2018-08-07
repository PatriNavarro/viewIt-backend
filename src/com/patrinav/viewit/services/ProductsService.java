package com.patrinav.viewit.services;

import com.patrinav.viewit.entities.Product;

import java.util.List;

public interface ProductsService {
    List<Product> getAll();
    Product get(Long id);
    List<Product> get(String type);
    Product update(Product product);
    Product create(Product product);
    Product delete(Product product);
}
