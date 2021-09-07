package pl.sda.service;

import pl.sda.model.Order;

import java.util.List;

public interface OrderService {

    void save(Order order);

    List<Order> findAll();

}
