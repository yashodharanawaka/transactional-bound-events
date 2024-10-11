package com.yhr.transactional_bound_events.service;

import com.yhr.transactional_bound_events.persistent.Order;
import com.yhr.transactional_bound_events.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class OrderServiceTest {

    @Mock
    private JmsTemplate jmsTemplate;

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @InjectMocks
    private OrderCreatedEventListener orderEventListener;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    public OrderServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testOrderCreatedJmsMessageSentAfterCommit() {
        //TODO
    }
}
