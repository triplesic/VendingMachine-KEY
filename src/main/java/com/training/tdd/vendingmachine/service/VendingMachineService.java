package com.training.tdd.vendingmachine.service;

import com.training.tdd.vendingmachine.model.Product;
import com.training.tdd.vendingmachine.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VendingMachineService {

    ProductRepository legacyProductRepo = new ProductRepository();

    public Map<String, Object> buyProduct(String string, long l) {

        boolean hasProduct = hasProduct(string);

        Map<String, Object> expected = new HashMap<>();

        if (hasProduct) {
            expected.put("product", string);
            expected.put("exchange", null);
            expected.put("message", "Thank you!");
        } else {
            expected.put("product", null);
            expected.put("exchange", Arrays.asList(15L));
            expected.put("message", "Sorry! no product");
        }

        return expected;
    }

    private boolean hasProduct(String product) {

        return legacyProductRepo.hasProduct(product);

    }

    public String getAllProducts() {

        List<Product> productList = legacyProductRepo.getAllProducts();
        String productListStr = "";

        if (productList.size() < 1) {
            productListStr = "ไม่มีสินค้าในเครื่อง";
        } else {
            for (Product product : productList) {
                productListStr += product.getName() + "(฿" + product.getPrice() + ") ";
            }
        }
        return productListStr;
    }
}
