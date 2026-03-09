package com.vir.b30.spring.java_based_bean_config;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {

    String bookName;
    int price;

    public Book(String bookName, int price) {
        this.bookName = bookName;
        this.price = price;
    }
}
