package com.exam.prime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.prime.bean.PrimeNumResp;

@SpringBootApplication
public class PrimeNumberApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeNumberApiApplication.class, args);
		
		PrimeNumResp resp = new PrimeNumResp();
		
	}

}
