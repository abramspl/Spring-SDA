package pl.sda.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.model.Order;
import pl.sda.repository.OrderRepository;
import pl.sda.service.OrderService;

import java.util.List;

@Service // robi to samo co @Component
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    //wstrzykiwanie przez konstruktor
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
