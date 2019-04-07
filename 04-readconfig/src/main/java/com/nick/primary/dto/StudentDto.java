package com.nick.primary.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource(value = "classpath:custom.properties",encoding = "UTF-8")
@ConfigurationProperties("student")
public class StudentDto {
    private String name;
    private int age;
    private double score;
}
