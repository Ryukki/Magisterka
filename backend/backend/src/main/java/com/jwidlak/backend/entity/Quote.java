package com.jwidlak.backend.entity;

import javax.persistence.*;

/**
 * Created by Ryukki on 02.10.2019.
 */
@Entity
@Table(name = "quotes_table")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id", unique = true)
    private Long id;

    @Basic(optional = false)
    @Column(name = "quoteText")
    private String quoteText;

    @Basic(optional = true)
    @Column(name = "quoteAuthor")
    private String quoteAuthor;

    public Quote() {
    }

    public Quote(String quoteText, String quoteAuthor) {
        this.quoteText = quoteText;
        this.quoteAuthor = quoteAuthor;
    }

    public Long getId() {
        return id;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    public void setQuoteAuthor(String quoteAuthor) {
        this.quoteAuthor = quoteAuthor;
    }
}
