package com.project.EcommercePurchasing.Kafka;


import com.project.EcommercePurchasing.Model.Order;
import com.project.EcommercePurchasing.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private final OrderService orderService;

    @Autowired
    public OrderConsumer(OrderService orderService) {
        this.orderService = orderService;
    }

    @KafkaListener(topics = "order_topic", groupId = "order-group")
    public void consumeOrder(Order order) {
        orderService.processOrder(order);
        System.out.println("Received order: " + order);
    }

}
