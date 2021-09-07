package pl.sda.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.model.Order;
import pl.sda.service.OrderService;

@Slf4j // obiekty typy log.
@RequestMapping("/orders")
@Controller
public class OrderController {

    private final OrderService orderService;

    //wstrzykiwanie przez konstruktor
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/create")
    public String showOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "order-create";
    }

    @PostMapping("/save")
    public String saveOrder(@ModelAttribute Order order) {

        log.info("Received order from frontend: " + order);

        orderService.save(order);
        return "redirect:/hello"; //wyślij żądanie typu get na ten adres (/hello) - odświeża stronę
    }

}
