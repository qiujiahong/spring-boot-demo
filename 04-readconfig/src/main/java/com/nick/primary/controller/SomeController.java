package com.nick.primary.controller;


import com.nick.primary.dto.CountryDto;
import com.nick.primary.dto.GroupDto;
import com.nick.primary.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
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


    @Autowired
    private StudentDto studentDto;

    @GetMapping(value = "/student")
    public StudentDto getStudent(){
        return  studentDto;
    }

    @Autowired
    private CountryDto countryDto;

    @GetMapping(value = "/country")
    public CountryDto getCountry(){
        return  countryDto;
    }



    @Autowired
    private GroupDto groupDto;

    @GetMapping(value = "/group")
    public GroupDto getGroup(){
        return  groupDto;
    }




}
