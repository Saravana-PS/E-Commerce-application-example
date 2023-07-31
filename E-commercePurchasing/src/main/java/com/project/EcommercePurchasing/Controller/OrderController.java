package com.project.EcommercePurchasing.Controller;


import com.project.EcommercePurchasing.Kafka.OrderProducer;
import com.project.EcommercePurchasing.Model.Order;
import com.project.EcommercePurchasing.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private final OrderProducer orderProducer;
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderProducer orderProducer, OrderService orderService) {
        this.orderProducer = orderProducer;
        this.orderService = orderService;
    }

    @PostMapping("/placeOrder")
    public Order placeOrder(@RequestBody Order order) {
        orderProducer.sendOrder(order);
        return orderService.placeOrder(order);
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PutMapping("/orders")
    public Order updateOrder(@RequestBody Order updatedOrder) {
        return orderService.updateOrder(updatedOrder);
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }


}
