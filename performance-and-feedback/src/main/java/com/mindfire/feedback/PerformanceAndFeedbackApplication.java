package com.mindfire.feedback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PerformanceAndFeedbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerformanceAndFeedbackApplication.class, args);
	}

}
