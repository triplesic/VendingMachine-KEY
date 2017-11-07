package com.training.tdd.vendingmachine.model;

public class Product {

	private String name;
	private Long price;

	public Product() {
		super();
	}

	public Product(String name, Long price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Product product = (Product) o;

		return this.name.equals(product.name);
	}

}
