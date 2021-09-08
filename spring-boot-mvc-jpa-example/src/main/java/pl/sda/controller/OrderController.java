package pl.sda.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.model.Order;
import pl.sda.service.OrderService;

import javax.validation.Valid;

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

    @PostMapping("/save")                                           // errors - taka lista z błędami
    public String saveOrder(@ModelAttribute @Valid Order order, Errors errors) {   //@Valid - walidujemy obiekt order z frontendu

        log.info("Received order from frontend: " + order);

        if (errors.hasErrors()) {
            log.warn("Order has errors: " + errors.getFieldError());
            return "order-create"; //jeśli wystąpią błędy to wracamy na tę stronę
        }

        orderService.save(order);
//        return "redirect:/hello"; //wyślij żądanie typu get na ten adres - (/hello), (redirect:) - odświeża stronę
        return "redirect:/orders/showAll";
    }

    @GetMapping("/showAll")
    public String showAll(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "order-list";
    }

}
