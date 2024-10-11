package com.yhr.transactional_bound_events.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@RequiredArgsConstructor
public class OrderCreatedEventListener {

    private final JmsTemplate jmsTemplate;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
        System.out.println("Order created: " + event.getOrder().getId());
        try {
            jmsTemplate.convertAndSend("order.queue", event.getOrder().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
