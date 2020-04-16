package com.babs.microservice.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.lang.String;
import com.babs.microservice.currencyexchangeservice.ExchangeValue;
import java.util.List;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue, Long>  {

	ExchangeValue findByFromAndTo(String from,String to);
}
