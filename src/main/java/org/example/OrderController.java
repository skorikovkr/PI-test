package org.example;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    private OrderRepository orderRepository;


    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("getAllOrders")
    public List<Order> getOrders() throws SQLException {
        return orderRepository.getOrders();
    }

    @PostMapping()
    public void postOrder(@RequestBody Order order) throws SQLException {
        this.orderRepository.addOrder(order);
    }

    @PutMapping("updateOrder/{id}")
    public void updateOrder(@PathVariable Long id, @RequestBody Order order) throws SQLException {
        this.orderRepository.updateOrder(id, order);
    }

    @GetMapping("getOrder/{id}")
    public Order getOrder(@PathVariable Long id) throws SQLException {
        return orderRepository.getOrder(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) throws SQLException {
        this.orderRepository.deleteOrder(id);
    }
}
