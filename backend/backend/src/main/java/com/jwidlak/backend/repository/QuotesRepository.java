package com.jwidlak.backend.repository;

import com.jwidlak.backend.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Ryukki on 02.10.2019.
 */
@Repository
public interface QuotesRepository extends JpaRepository<Quote, Long>{
    Optional<Quote> findById(Long id);

    boolean existsByQuoteText(String quoteText);

    Quote getByQuoteText(String quoteText);

    long count();
}
