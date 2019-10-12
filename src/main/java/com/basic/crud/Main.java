package com.basic.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextException;

/**
 * @author lazaro on 10/12/2019.
 * @project basicCrud
 */
@SpringBootApplication
public class Main {
    public static void main (String[] args){
        SpringApplication.run(Main.class, args);
        System.out.println("test");
    }
}
