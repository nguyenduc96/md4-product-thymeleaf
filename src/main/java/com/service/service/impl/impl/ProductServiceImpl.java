package com.service.service.impl.impl;

import com.service.model.Product;
import com.service.service.impl.IProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    private static List<Product> products;

    static  {
        products = new ArrayList<>();
        products.add(new Product((int) (Math.random() * 10000), "Iphone", "new", "img"));
        products.add(new Product((int) (Math.random() * 10000), "Iphone1", "new", "img"));
        products.add(new Product((int) (Math.random() * 10000), "Iphone2", "new", "img"));
        products.add(new Product((int) (Math.random() * 10000), "Iphone3", "new", "img"));
        products.add(new Product((int) (Math.random() * 10000), "Iphone4", "new", "img"));
        products.add(new Product((int) (Math.random() * 10000), "Iphone5", "new", "img"));
    }

    @Override
    public boolean save(Product product) {
        return products.add(product);
    }

    @Override
    public boolean delete(int id) {
        return products.removeIf(product -> product.getId() == id);
    }

    @Override
    public Product update(int id, Product product) {
        Product oldProduct = findProductById(id);
        oldProduct.setName(product.getName());
        oldProduct.setImage(product.getImage());
        oldProduct.setDescription(product.getDescription());
        return oldProduct;
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product findProductById(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public int count() {
        return products.size();
    }
}
