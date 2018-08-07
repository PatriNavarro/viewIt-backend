package com.patrinav.viewit.services;

import com.patrinav.viewit.dao.ProductDao;
import com.patrinav.viewit.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbProductsService implements ProductsService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public Product get(Long id) {
        return null;
    }

    @Override
    public List<Product> get(String type) {
        return productDao.get(type);
    }


    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public Product create(Product product) {
        return null;
    }

    @Override
    public Product delete(Product product) {
        return null;
    }
}
