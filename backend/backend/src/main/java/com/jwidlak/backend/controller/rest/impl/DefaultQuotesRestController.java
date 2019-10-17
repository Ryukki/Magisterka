package com.jwidlak.backend.controller.rest.impl;

import com.jwidlak.backend.controller.rest.QuotesRestController;
import com.jwidlak.backend.entity.Quote;
import com.jwidlak.backend.service.QuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ryukki on 03.10.2019.
 */
@RestController
public class DefaultQuotesRestController implements QuotesRestController {

    private final QuotesService defaultQuotesService;

    @Autowired
    public DefaultQuotesRestController(QuotesService defaultQuotesService) {
        this.defaultQuotesService = defaultQuotesService;
    }

    @Override
    public ResponseEntity<Quote> getRandomQuote() {
        return new ResponseEntity<>(defaultQuotesService.getRandomQuote(), HttpStatus.OK);
    }

    @Override
    public HttpStatus addNewQuote(Quote quote) {
        defaultQuotesService.addQuote(quote);
        return HttpStatus.OK;
    }

}
