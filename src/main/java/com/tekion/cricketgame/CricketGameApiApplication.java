package com.tekion.cricketgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CricketGameApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CricketGameApiApplication.class, args);
	}


}
