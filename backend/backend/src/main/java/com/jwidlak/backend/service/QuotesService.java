package com.jwidlak.backend.service;

import com.jwidlak.backend.entity.Quote;
import org.springframework.stereotype.Service;

/**
 * Created by Ryukki on 03.10.2019.
 */
@Service
public interface QuotesService {

    Quote getRandomQuote();

    Quote addQuote(String quoteText, String quoteAuthor);

    Quote addQuote(Quote quote);

}
