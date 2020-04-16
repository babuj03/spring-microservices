package com.babs.microservice.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CurrencyExchangeProxy proxy;
	
	@GetMapping("/currency-convert/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvertionBean convertCurrency(@PathVariable String from,  @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		//Map<String,String> uriVariables = new HashMap<String, String>();
	//	uriVariables.put("from", from);
	////	uriVariables.put("to",to);
		//ResponseEntity<CurrencyConvertionBean> resEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConvertionBean.class,uriVariables);
		
	   // CurrencyConvertionBean res = resEntity.getBody();
	  
	    CurrencyConvertionBean res = proxy.currencyExchange(from, to);
	     System.out.println("==========="+res);
	    res.setTotalCalculatedAmount(res.getConversionMultiple().multiply(quantity));
		res.setQuantity(quantity);	
		
		logger.info("After Added Sleuth  {}", res);
		return  res;//new CurrencyConvertionBean(1l, "usa", "inr",  BigDecimal.valueOf(10),  BigDecimal.valueOf(10),BigDecimal.valueOf(10), 0);
	}

}
