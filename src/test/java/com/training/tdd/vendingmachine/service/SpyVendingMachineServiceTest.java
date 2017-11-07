package com.training.tdd.vendingmachine.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.training.tdd.vendingmachine.repo.ProductRepository;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpyVendingMachineServiceTest {

	@InjectMocks
	VendingMachineService vendingMachineService; // system under test

	@Spy
	ProductRepository lagacyProductRepo;

	@Test
	public void shouldReturnCokeAndThankyouMsgWhenSelectCodeAndInsertEnoughMoney() {
		// given
		Map<String, Object> expected = new HashMap<>();

		expected.put("product", "Coke");
		expected.put("exchange", null);
		expected.put("message", "Thank you!");

		// when
		Map<String, Object> result = vendingMachineService.buyProduct("Coke", 12L);

		// then
		verify(lagacyProductRepo, times(1)).hasProduct("Coke");

		Assert.assertEquals(expected, result);
	}
}
