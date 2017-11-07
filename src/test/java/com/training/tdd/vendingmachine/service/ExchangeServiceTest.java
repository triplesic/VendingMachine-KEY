package com.training.tdd.vendingmachine.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExchangeServiceTest {

	@InjectMocks
	ExchangeService exchangeService;

	@Test
	public void shouldReturn100WhenAmount100() {
		List<Long> actual = exchangeService.exchange(100L);

		List<Long> expected = Arrays.asList(100L);

		Assert.assertEquals(expected, actual);

	}

	@Test
	public void shouldReturn100x2WhenAmountIs200() {
		List<Long> actual = exchangeService.exchange2(200L);

		List<Long> expected = Arrays.asList(100L, 100L);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void shouldReturn500WhenAmountIs500() {
		List<Long> actual = exchangeService.exchange3(500L);

		List<Long> expected = Arrays.asList(500L);

		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturn500and100x2WhenAmountIs700() {
		List<Long> actual = exchangeService.exchange3(700L);

		List<Long> expected = Arrays.asList(500L, 100L, 100L);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void shouldReturn1000WhenAmountIs1000() {
		List<Long> actual = exchangeService.exchange4(1000L);

		List<Long> expected = Arrays.asList(1000L);

		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturn1000and500and100x3WhenAmountIs1800() {
		List<Long> actual = exchangeService.exchange4(1800L);

		List<Long> expected = Arrays.asList(1000L, 500L, 100L, 100L, 100L);

		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturn1000and500and100x3WhenAmountIs1800Refactor() {
		List<Long> actual = exchangeService.exchange5(1800L);

		List<Long> expected = Arrays.asList(1000L, 500L, 100L, 100L, 100L);

		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturn1000and500and100x3and20WhenAmountIs1820Refactor() {
		List<Long> actual = exchangeService.exchange6(1820L);

		List<Long> expected = Arrays.asList(1000L, 500L, 100L, 100L, 100L, 20L);

		Assert.assertEquals(expected, actual);
	}
}
