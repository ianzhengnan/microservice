package com.ian.springrabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @RabbitListener(queues = "my-queue")
    public void receiveMessage(String message){
        System.out.println("Received <" + message + ">");
    }
}
