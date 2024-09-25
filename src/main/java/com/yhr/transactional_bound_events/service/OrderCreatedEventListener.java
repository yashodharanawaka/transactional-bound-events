package com.yhr.transactional_bound_events.service;

import com.yhr.transactional_bound_events.persistent.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@RequiredArgsConstructor
public class EventPublisher {

    private final JmsTemplate jmsTemplate;

    @TransactionalEventListener
    public void publish(Order order) {
        try {
            jmsTemplate.convertAndSend("order.queue", order.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
