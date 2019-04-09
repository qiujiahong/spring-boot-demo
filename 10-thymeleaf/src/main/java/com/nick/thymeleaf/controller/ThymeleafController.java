package com.nick.thymeleaf.controller;


import com.nick.thymeleaf.vo.StudentVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {

    @RequestMapping("/")
    public String indexHandle(Model model){
        model.addAttribute("name","nick");
        model.addAttribute("student",new StudentVO("nick",12));
        return "index";
    }
}
