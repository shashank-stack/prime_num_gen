package com.exam.prime;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 

 

@SpringBootApplication
@EnableSwagger2
public class PrimeNumberApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeNumberApiApplication.class, args);		
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/**"))
				.apis(RequestHandlerSelectors.basePackage("com.exam"))
				.build()
				.apiInfo(apidetails());
	}
	
	private ApiInfo apidetails() {
		
		return new ApiInfo(
				"Prime Number Generation API",
				"Prime Number Generation API which generates prime numbers upto or equal to a given number",
				"1.0",
				"Open Source",
				new springfox.documentation.service.Contact("Shashank","NA" , "test@gmail.com"),
				"API License",
				"NA",
				Collections.emptyList()
				);
		
	}
	
	

}


