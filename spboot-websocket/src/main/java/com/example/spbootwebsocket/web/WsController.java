package com.example.spbootwebsocket.web;

import com.example.spbootwebsocket.domain.IanMessage;
import com.example.spbootwebsocket.domain.IanResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WsController {

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public IanResponse say(IanMessage message) throws Exception{
//        Thread.sleep(3000);
        return new IanResponse("Welcome, " + message.getName() + "!");
    }
}
