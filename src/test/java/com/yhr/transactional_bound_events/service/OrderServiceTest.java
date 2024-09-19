package com.yhr.transactional_bound_events.service;

import com.yhr.transactional_bound_events.persistent.Order;
import com.yhr.transactional_bound_events.repository.OrderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private EventPublisher eventPublisher;
    @Mock
    private OrderListener orderListener;

    @InjectMocks
    private OrderService orderService;

    private AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void createOrder() throws InterruptedException {
        orderService.createOrder();

        verify(orderRepository, times(1)).save(any(Order.class));
        verify(eventPublisher, times(1)).publish(any(Order.class));
        Thread.sleep(30000);
    }
}