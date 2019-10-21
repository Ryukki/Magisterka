package com.jwidlak.backend.controller.rest;

import com.jwidlak.backend.entity.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Ryukki on 02.10.2019.
 */
@RestController
@RequestMapping("/")
public interface QuotesRestController {

    @CrossOrigin()
    @GetMapping("/randomQuote")
    public ResponseEntity<Quote> getRandomQuote();

    @PostMapping("/addQuote")
    public HttpStatus addNewQuote(@RequestBody Quote quote);

    @GetMapping("/status")
    public HttpStatus checkStatus();
}
