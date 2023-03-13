package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class OrderConfiguration {
    @Bean
    public Order order(List<OrderPosition> orderPositionList) {
        final var order = new Order();
        order.setId(1L);
        order.setComment("Hello world");
        return order;
    }

    @Bean
    public List<OrderPosition> orderPositionList() {
        final var list = new ArrayList<OrderPosition>();
        final var pos1 = new OrderPosition();
        pos1.setOrderId(1L);
        pos1.setId(2L);
        pos1.setPrice(123123.0);
        list.add(pos1);
        final var pos2 = new OrderPosition();
        pos2.setOrderId(1L);
        pos2.setId(3L);
        pos2.setPrice(666.0);
        list.add(pos2);
        return list;
    }

    @Bean
    public List<Order> orderList() {
        return new ArrayList<>();
    }
}
