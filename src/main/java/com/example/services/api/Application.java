package com.example.services.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan({ "com.example.services", "com.example.common"})
@EnableJpaRepositories(basePackages = { "com.example.common.jpa.**.dao", "com.example.services.api.**.dao" })
@EntityScan(basePackages = { "com.example.common.jpa.**.model", "com.example.services.api.**.model" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
