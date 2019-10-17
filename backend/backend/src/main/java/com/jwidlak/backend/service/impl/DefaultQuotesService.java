package com.jwidlak.backend.service.impl;

import com.jwidlak.backend.entity.Quote;
import com.jwidlak.backend.repository.QuotesRepository;
import com.jwidlak.backend.service.QuotesService;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Created by Ryukki on 03.10.2019.
 */
@Service
public class DefaultQuotesService implements QuotesService{

    private final QuotesRepository quotesRepository;

    private RandomDataGenerator randomGenerator;

    @Autowired
    public DefaultQuotesService(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
        randomGenerator = new RandomDataGenerator();
    }

    @Override
    public Quote getRandomQuote() {
        /*try {
            readQuotes();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        long numberOfQuotes = quotesRepository.count();
        long id = randomGenerator.nextLong(1, numberOfQuotes);
        Optional<Quote> quote = quotesRepository.findById(id);
        return quote.orElseGet(() -> quotesRepository.getOne(1L));
    }

    @Override
    public Quote addQuote(String quoteText, String quoteAuthor) {
        Quote quote = new Quote(quoteText, quoteAuthor);
        return addQuote(quote);
    }

    @Override
    public Quote addQuote(Quote quote) {
        String quoteText = quote.getQuoteText();
        if(checkIfExist(quoteText)){
            return quotesRepository.getByQuoteText(quoteText);
        }else {
            return quotesRepository.save(quote);
        }
    }

    private boolean checkIfExist(String quoteText){
        return quotesRepository.existsByQuoteText(quoteText);
    }

    /*private void readQuotes() throws IOException {
        String path = "F:\\VS Code\\Python\\Magisterka\\data2.sql";
        File file = new File(path);

        int counter = 0;
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line;
        Quote quote = new Quote();
        boolean shouldAdd=true;
        while((line = br.readLine()) != null)
        {
            if(counter++%2==0){
                quote = new Quote();
                quote.setQuoteText(line);
                shouldAdd = !checkIfExist(line);
            }else {
                quote.setQuoteAuthor(line);
                if(shouldAdd) {
                    quotesRepository.save(quote);
                }
            }
        }
        br.close();
        fr.close();
    }*/
}
