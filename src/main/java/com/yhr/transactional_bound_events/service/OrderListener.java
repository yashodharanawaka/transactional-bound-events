package com.yhr.transactional_bound_events.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    @JmsListener(destination = "order.queue")
    public void receiveOrderMessage(String message) {
        System.out.println(STR."Received Order Message: \{message}");
    }
}
