package com.service.service.impl;

import com.service.model.Product;

import java.util.List;

public interface IProductService {
    boolean save(Product product);

    boolean delete(int id);

    Product update(int id, Product product);

    List<Product> getAll();

    Product findProductById(int id);

    int count();
}
