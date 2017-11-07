package com.training.tdd.vendingmachine.repo;

import java.util.ArrayList;
import java.util.List;

import com.training.tdd.vendingmachine.model.Product;

public class ProductRepository implements IProductRepository // comment or
																// uncomment
																// when want to
																// show adapter
																// pattern
{
	// Database representation
	private List<Product> dataSet;

	public ProductRepository() {
		this.dataSet = new ArrayList<>();
		this.dataSet.add(new Product("Coke", 12L));
		this.dataSet.add(new Product("Instant Noodle", 6L));
		this.dataSet.add(new Product("Lay", 10L));
	}

	public boolean hasProduct(String productName) {
		List resultSet = getAllProducts();
		System.out.println("result set size : " + resultSet.size());
		Product parameter = new Product();
		parameter.setName(productName);
		System.out.println("product : " + parameter.getName() + parameter.getPrice());
		System.out.println("contain : " + resultSet.contains(parameter));
		return resultSet.contains(parameter);
	}

	public List<Product> getAllProducts() {
		return this.dataSet;
	}
}
