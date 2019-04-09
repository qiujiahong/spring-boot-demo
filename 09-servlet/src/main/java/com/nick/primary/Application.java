package com.nick.primary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.nick.primary.servlet")//开启servlet扫描
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
