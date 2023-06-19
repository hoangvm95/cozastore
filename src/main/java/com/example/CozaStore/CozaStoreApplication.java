package com.example.CozaStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CozaStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CozaStoreApplication.class, args);
	}

}
