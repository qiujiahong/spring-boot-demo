package com.nick.primary.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {

    @GetMapping("/frist/some")
    public String firstHandle() {
        return "first";
    }

    @GetMapping("/second/other")
    public String secondHandle() {
        return "second";
    }
}
