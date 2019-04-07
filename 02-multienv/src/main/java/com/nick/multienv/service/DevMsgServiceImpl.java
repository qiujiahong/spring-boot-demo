package com.nick.multienv.service;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DevMsgServiceImpl implements MsgService {
    @Override
    public String  send() {
        System.out.println("----------DevMsgServiceImpl-----------");
        return "dev";
    }
}
