package com.flightmanagement.flightmanagement_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.flightmanagement")
@EntityScan(basePackages = "com.flightmanagement.model")
@EnableJpaRepositories(basePackages = "com.flightmanagement.Repository")
public class FlightmanagementApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightmanagementApiApplication.class, args);
    }
}