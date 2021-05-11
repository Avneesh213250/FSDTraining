package com.group2.FSD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class FsdBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(FsdBankApplication.class, args);
	}

}
