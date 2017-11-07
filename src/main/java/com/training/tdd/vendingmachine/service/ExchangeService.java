package com.training.tdd.vendingmachine.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ExchangeService {

	public List<Long> exchange(long money) {
		List<Long> result = Arrays.asList(100L);
		return result;
	}

	public List<Long> exchange2(long money) {
		List<Long> result = new ArrayList<>();
		while (money >= 100L) {
			result.add(100L);
			money -= 100L;
		}
		return result;
	}

	public List<Long> exchange3(long money) {
		List<Long> result = new ArrayList<>();
		while (money >= 500L) {
			result.add(500L);
			money -= 500L;
		}
		while (money >= 100L) {
			result.add(100L);
			money -= 100L;
		}
		return result;
	}

	public List<Long> exchange4(long money) {
		List<Long> result = new ArrayList<>();
		while (money >= 1000L) {
			result.add(1000L);
			money -= 1000L;
		}
		while (money >= 500L) {
			result.add(500L);
			money -= 500L;
		}
		while (money >= 100L) {
			result.add(100L);
			money -= 100L;
		}
		return result;
	}

	public List<Long> exchange5(long money) {
		List<Long> moneyLevelList = Arrays.asList(1000L, 500L, 100L);

		List<Long> result = new ArrayList<>();

		for (Long moneyLvl : moneyLevelList) {
			while (money >= moneyLvl) {
				result.add(moneyLvl);
				money -= moneyLvl;
			}
		}
		return result;
	}
	
	public List<Long> exchange6(long money) {
		List<Long> moneyLevelList = Arrays.asList(1000L, 500L, 100L, 20L);

		List<Long> result = new ArrayList<>();

		for (Long moneyLvl : moneyLevelList) {
			while (money >= moneyLvl) {
				result.add(moneyLvl);
				money -= moneyLvl;
			}
		}
		return result;
	}
}
