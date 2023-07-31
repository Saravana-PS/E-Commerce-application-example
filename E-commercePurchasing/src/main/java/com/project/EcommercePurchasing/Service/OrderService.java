package com.project.EcommercePurchasing.Service;


import com.project.EcommercePurchasing.Model.Order;
import com.project.EcommercePurchasing.Model.OrderStatus;
import com.project.EcommercePurchasing.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order placeOrder(Order order) {
        order.setStatus(OrderStatus.PLACED);
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order updateOrder(Order updatedOrder) {
        Order existingOrder = orderRepository.findByOrderId(updatedOrder.getOrderId());
        if (existingOrder != null) {
            existingOrder.setCustomerId(updatedOrder.getCustomerId());
            existingOrder.setItems(updatedOrder.getItems());
            existingOrder.setStatus(updatedOrder.getStatus());
            return orderRepository.save(existingOrder);
        }
        return null;
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public void processOrder(Order order) {
        order.setStatus(OrderStatus.PROCESSING);
        orderRepository.save(order);
    }

}
