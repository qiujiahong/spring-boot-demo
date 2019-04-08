package com.nick.jspdemo.controller;


import com.nick.jspdemo.bean.Employee;
import com.nick.jspdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/register")
    public String add(Employee employee){
        employeeService.addEmployee(employee);
        return "page/welcome";
    }

}
