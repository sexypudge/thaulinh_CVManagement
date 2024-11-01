package com.thaulinh.apigatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayServiceApplication.class, args);
	}
	@Bean
	public ConversionService conversionService() {
		// Create and configure your ConversionService bean here
		DefaultConversionService conversionService = new DefaultConversionService();
		// Add custom converters as needed
		return conversionService;
	}
}
