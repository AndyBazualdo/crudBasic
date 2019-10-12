package com.basic.crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lazaro on 10/12/2019.
 * @project basicCrud
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public String SayHello(){
        return "Hello";
    }
}
