package com.challenge.starwarsfilms.controller;

import com.challenge.starwarsfilms.dto.OpeningCrawlRequest;
import com.challenge.starwarsfilms.service.MainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/films")
public class MainController {

    MainService service;
    public MainController(MainService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<Object> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id) {
        return service.findOne(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editOpeningCrawl(@PathVariable Integer id,
                                                  @RequestBody OpeningCrawlRequest description){
        return service.editOpeningCrawl(id, description.getOpeningCrawl());
    };
}
