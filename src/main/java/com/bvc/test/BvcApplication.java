package com.bvc.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class },scanBasePackages={"com.*"})
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class BvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(BvcApplication.class, args);
	}

}
