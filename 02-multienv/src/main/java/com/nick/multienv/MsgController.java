package com.nick.multienv;


import com.nick.multienv.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {


    @Autowired
    MsgService msgService;

    @GetMapping("/send")
    public String sendHandle(){
        return  msgService.send();
    }
}
