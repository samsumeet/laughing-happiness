package com.app.repaymentapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RepaymentapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepaymentapiApplication.class, args);
	}

}
