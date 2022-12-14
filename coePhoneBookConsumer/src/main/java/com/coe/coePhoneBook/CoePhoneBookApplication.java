package com.coe.coePhoneBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class CoePhoneBookApplication {

	public static void main(String[] args) {

		SpringApplication.run(CoePhoneBookApplication.class, args);
	}

}
