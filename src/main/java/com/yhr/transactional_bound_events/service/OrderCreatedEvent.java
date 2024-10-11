package com.yhr.transactional_bound_events.service;

import com.yhr.transactional_bound_events.persistent.Order;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrderCreatedEvent {
    private final Order order;

}
