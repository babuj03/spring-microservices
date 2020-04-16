package com.babs.microservice.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLogginFilter extends com.netflix.zuul.ZuulFilter {

	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//Check request with certain things present or not
	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
	HttpServletRequest requst =	RequestContext.getCurrentContext().getRequest();
	logger.info("------------------------request -> {} request uri ->{}", requst, requst.getRequestURI());
		return null;
	}

	
	// pre or post or error case this filter shoud executed
	@Override
	public String filterType() {
		
		return "pre";
	}

	
	// Giving order of execution in this below method
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
