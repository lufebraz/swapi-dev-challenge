package com.challenge.starwarsfilms;

import com.challenge.starwarsfilms.service.MainService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarWarsFilmsApplication {

	static MainService service;
	public StarWarsFilmsApplication(MainService service) {
		this.service = service;
	}
	public static void main(String[] args) {
		SpringApplication.run(StarWarsFilmsApplication.class, args);

		service.initialSave();
	}

}
