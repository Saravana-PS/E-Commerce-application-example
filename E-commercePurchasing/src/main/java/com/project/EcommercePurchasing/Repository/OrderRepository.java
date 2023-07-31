package com.project.EcommercePurchasing.Repository;


import com.project.EcommercePurchasing.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByOrderId(String orderId);

}
