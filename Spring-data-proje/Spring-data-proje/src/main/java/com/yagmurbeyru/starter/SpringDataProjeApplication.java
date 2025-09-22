package com.yagmurbeyru.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.yagmurbeyru"})
@ComponentScan(basePackages = {"com.yagmurbeyru"})
@EnableJpaRepositories(basePackages = {"com.yagmurbeyru"})
@SpringBootApplication
public class SpringDataProjeApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringDataProjeApplication.class, args);
	}

}
