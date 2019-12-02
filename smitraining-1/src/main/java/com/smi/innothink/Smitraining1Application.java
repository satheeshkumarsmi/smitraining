package com.smi.innothink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"com.smi.innothink.controller"})
public class Smitraining1Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Smitraining1Application.class, args);
	}

}
