package com.nick.multienv.service;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("pro")
public class ProMsgServiceImpl implements MsgService {
    @Override
    public String send() {
        System.out.println("----------ProMsgServiceImpl-----------");
        return "pro";

    }
}
