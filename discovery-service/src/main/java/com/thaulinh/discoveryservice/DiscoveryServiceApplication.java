package com.thaulinh.discoveryservice;

import com.netflix.discovery.shared.transport.jersey.TransportClientFactories;
import com.netflix.discovery.shared.transport.jersey3.Jersey3TransportClientFactories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServiceApplication.class, args);
    }

    @Bean
    public TransportClientFactories<?> jersey3TransportClientFactories() {
        return new Jersey3TransportClientFactories();
    }

}
