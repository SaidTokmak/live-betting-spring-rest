package com.saidtokmak.livebetting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LivebettingApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivebettingApplication.class, args);
	}

}
