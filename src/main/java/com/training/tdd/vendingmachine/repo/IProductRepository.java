package com.training.tdd.vendingmachine.repo;

import java.util.List;

import com.training.tdd.vendingmachine.model.Product;

public interface IProductRepository {

    public boolean hasProduct(String product);

    public List<Product> getAllProducts();

}