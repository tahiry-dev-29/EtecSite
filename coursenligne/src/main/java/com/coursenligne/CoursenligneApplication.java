package com.coursenligne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CoursenligneApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursenligneApplication.class, args);
	}

}
