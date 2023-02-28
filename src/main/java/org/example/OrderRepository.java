package org.example;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class OrderRepository {

    private final HashMap<Long, Order> orders = new HashMap<>();
    Long lastId = 0L;

    public void addOrder(Order order) {
        orders.put(lastId, order);
        order.setId(lastId);
        lastId++;
    }

    public List<Order> getOrders() {
        return orders.values().stream().toList();
    }

    public Order getOrder(Long id) {
        return orders.get(id);
    }

    public void deleteOrder(Long id) {
        orders.remove(id);
    }
}
