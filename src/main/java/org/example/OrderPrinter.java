package org.example;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderPrinter {
    Order order;

    public OrderPrinter(Order order) {
        this.order = order;
    }
}
