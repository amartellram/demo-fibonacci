package com.amspace.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amspace.demo.FibonacciFeatureConfig;
import com.amspace.demo.bean.FibonacciNumber;
import com.amspace.demo.service.FibonacciService;

@RestController
public class FibonacciRestController {

	@Autowired
	private FibonacciFeatureConfig config;
	
	@Autowired
	@Qualifier("fibonacci")
	private FibonacciService fibonacciProvider;
	
	@RequestMapping(value = "/fibonacci", method = RequestMethod.GET)
	public FibonacciNumber fibonacci(@RequestParam(value = "number", defaultValue = "0") int number) {
		if(config.isRestEnabled()) {
			int fibonacciValue = fibonacciProvider.getNthNumber(number);
			return new FibonacciNumber(number, fibonacciValue);
		}else 
			throw new UnsupportedOperationException();
	}
	
	@ExceptionHandler(UnsupportedOperationException.class)
	public void unsupportedException(HttpServletResponse response ) throws IOException{
		response.sendError(HttpStatus.SERVICE_UNAVAILABLE.value(), "This feature is currently unavailable");
	}
	
	@ExceptionHandler(Exception.class)
	public void handleGenericException(HttpServletResponse response, Exception e ) throws IOException{
		String msg = "There was an erro processing your request: " + e.getMessage();
		response.sendError(HttpStatus.BAD_REQUEST.value(), msg);
	}
}
