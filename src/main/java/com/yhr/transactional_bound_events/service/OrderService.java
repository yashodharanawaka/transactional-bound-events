package com.yhr.transactional_bound_events.service;


import com.yhr.transactional_bound_events.persistent.Order;
import com.yhr.transactional_bound_events.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final EventPublisher eventPublisher;

    @Transactional
    public void createOrder() {
        Order order = new Order();
        order.setDescription("Some order");
        orderRepository.save(order);
        eventPublisher.publish(order);

    }
}
