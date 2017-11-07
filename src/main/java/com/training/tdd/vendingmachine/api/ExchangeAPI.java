package com.training.tdd.vendingmachine.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.tdd.vendingmachine.service.ExchangeService;

@RestController
@RequestMapping("/api/exchange")
public class ExchangeAPI {

	@Autowired
	ExchangeService exchangeService;

	@GetMapping
	public ResponseEntity<?> helloWorld() {
		return ResponseEntity.ok("Hello world");
	}

	@GetMapping("/{amount}")
	public ResponseEntity<?> exchangeMoney(@Valid @PathVariable("amount") Long amount) {
		return ResponseEntity.ok(exchangeService.exchange6(amount));
	}
}
