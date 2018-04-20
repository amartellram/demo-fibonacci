package com.amspace.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "features.fibonacci")
public class FibonacciFeatureConfig {

	private boolean restEnabled;

	public boolean isRestEnabled() {
		return restEnabled;
	}

	public void setRestEnabled(boolean restEnabled) {
		this.restEnabled = restEnabled;
	}
	
	
	
}
