package com.vir.b30.spring.java_based_bean_config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(config.class);

        Book book = context.getBean(Book.class);
        Book book2 = context.getBean(Book.class);

        System.out.println("Book HashCode 1 : " + book.hashCode());
        System.out.println("Book HashCode 2 : " + book2.hashCode());

        // Calling BookPublisher bean
        BookPublisher publisher = context.getBean(BookPublisher.class);
        System.out.println(publisher);
    }
}
