package com.babs.microservice.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	Environment env;
	@Autowired
	CurrencyExchangeRepository respository;
//	http://localhost:8000/currency-exchange/from/USA/to/INR/
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue currencyExchange(@PathVariable String from, @PathVariable String to) {		
		//new ExchangeValue(from, to, BigDecimal.valueOf(100.0), Integer.parseInt(env.getProperty("local.server.port")));
		ExchangeValue ex =	respository.findByFromAndTo(from, to);
		ex.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		logger.info("After Added Sleuth  {}", ex);
		return ex;
	}

}
