package org.example;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("details")
    public List<Order> getOrders() {
        return orderRepository.getOrders();
    }

    @PostMapping()
    public void postOrder(@RequestBody Order order) {
        this.orderRepository.addOrder(order);
    }

    @GetMapping("getOrder/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderRepository.getOrder(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        this.orderRepository.deleteOrder(id);
    }
}
