package com.vir.b30.spring.java_based_bean_config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BookPublisher {

    Book book;

    // Constructor Injection
    @Autowired
    public BookPublisher(Book book) {
        this.book = book;
    }

    // Field Injection
    @Autowired
    ComicsBook comicsBook;

    @Autowired
    @Qualifier("thrillerBook")
    Publish publish;

    // Method Injection
    @Autowired
    public void check(Book book) {
        System.out.println("\nInside Method Injection");
        comicsBook.show();
        publish.show();
        System.out.println("Book Hash from method: " + book.hashCode());
    }

    // Setter Injection
    @Autowired
    public void setBook(Book book) {
        this.book = book;
    }
}
