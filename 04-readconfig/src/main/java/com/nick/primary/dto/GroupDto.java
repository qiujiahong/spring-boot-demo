package com.nick.primary.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@PropertySource(value = "classpath:custom.properties",encoding = "UTF-8")
@ConfigurationProperties("group")
public class GroupDto {
    List<User> users;
}
