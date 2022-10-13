package com.challenge.starwarsfilms;

import com.challenge.starwarsfilms.service.MainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarWarsFilmsApplication {

	private static final Logger log = LoggerFactory.getLogger(StarWarsFilmsApplication.class);
	static MainService service;
	public StarWarsFilmsApplication(MainService service) {
		this.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(StarWarsFilmsApplication.class, args);
		log.info("SEARCHING FOR INTERGALACTIC MOVIES .....");
		service.initialSave();
	}

}
