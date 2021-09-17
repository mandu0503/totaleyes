package com.kt.totaleyes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@EnableEncryptableProperties
@SpringBootApplication
public class TotaleyesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TotaleyesApplication.class, args);
	}

}
