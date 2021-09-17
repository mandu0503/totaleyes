package com.kt.totaleyes;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JasyptsampleApplication implements CommandLineRunner {
	
	//properties 암호화 생성용
	public static void main(String[] args) {
		//SpringApplication.run(JasyptsampleApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		StandardPBEStringEncryptor spe = new StandardPBEStringEncryptor();
		spe.setAlgorithm("PBEWithMD5AndDES");
		spe.setPassword("totaleyes");
		System.out.println("db username = " + spe.encrypt("totaleyes"));
		System.out.println("db password = " + spe.encrypt("1234"));
	}
		
}
