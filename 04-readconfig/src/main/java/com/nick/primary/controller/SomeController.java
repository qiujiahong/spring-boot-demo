package com.nick.primary.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource(value = "classpath:custom.properties",encoding = "UTF-8") //如果有汉字
//@PropertySource("classpath:custom.properties")
public class SomeController {

    @Value("${company.name}")
    private String companyName;

    @Value("${city.name}")
    private String cityName;

    @GetMapping(value = "/some",produces = "application/json;charset=UTF-8")
    public String someHandle(){
        return "hello "+ companyName;
    }
    @GetMapping(value = "/city")
    public String getCity(){
        return "hello "+ cityName;
    }

}
