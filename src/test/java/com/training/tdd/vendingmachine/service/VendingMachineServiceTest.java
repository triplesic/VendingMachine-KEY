package com.training.tdd.vendingmachine.service;

import com.training.tdd.vendingmachine.model.Product;
import com.training.tdd.vendingmachine.repo.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendingMachineServiceTest {

    @InjectMocks
    VendingMachineService vendingMachineService;

    @Mock
    ProductRepository legacyProductRepo;

    @Test
    public void shouldReturnNoProductWhenTheMachineHasNoProduct() {

        List<Product> emptyProductList = new ArrayList();

        Mockito.doReturn(emptyProductList).when(legacyProductRepo).getAllProducts();

        String productListStr = vendingMachineService.getAllProducts();

        Assert.assertEquals("ไม่มีสินค้าในเครื่อง", productListStr);
    }

    @Test
    public void shouldReturnListOfProductAndPriceWhenThemachineHasProducts() {
        List<Product> productList = new ArrayList();
        productList.add(new Product("Coke", 15L));
        productList.add(new Product("Coffee", 10L));
        productList.add(new Product("Tea", 12L));

        Mockito.doReturn(productList).when(legacyProductRepo).getAllProducts();

        String productListStr = vendingMachineService.getAllProducts();

        Assert.assertEquals("Coke(฿15) Coffee(฿10) Tea(฿12)", productListStr.trim());
    }


    @Test
    public void shouldReturnMessageNoProductAndExchangeAllMoneyWhenNoItemInVendingMachine() {

        Mockito.doReturn(false).when(legacyProductRepo).hasProduct("Coke");

        Map<String, Object> result = vendingMachineService.buyProduct("Coke", 12L);
        Map<String, Object> expected = new HashMap<>();

        expected.put("product", null);
        expected.put("exchange", Arrays.asList(15L));
        expected.put("message", "Sorry! no product");

        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldReturnCokeAndThankyouMsgWhenSelectCodeAndInsertEnoughMoney() {

        Mockito.doReturn(true).when(legacyProductRepo).hasProduct("Coke");

        Map<String, Object> result = vendingMachineService.buyProduct("Coke", 12L);
        Map<String, Object> expected = new HashMap<>();

        expected.put("product", "Coke");
        expected.put("exchange", null);
        expected.put("message", "Thank you!");

        Assert.assertEquals(expected, result);
    }
}
