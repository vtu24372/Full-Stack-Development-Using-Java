package com.vir.b30.spring.java_based_bean_config;

import org.springframework.stereotype.Component;

@Component
public class ComicsBook implements Publish {

    public void show() {
        System.out.println("Comics Book");
    }
}
