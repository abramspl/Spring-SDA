package pl.sda.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Slf4j //adnotacja z lomboka
@Controller //obiekt tej kasy będzie bean i obsługuje żądania HTTP
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "welcome"; //nazwa pliku o rozszerzeniu .html
    }

    @GetMapping("/hello-msg")
    public String helloMessage(Model model) { // spring dostarcza automatycznie obiekt Model

        //atrybuty do odczytania w pliku HTML
        model.addAttribute("helloMsg", "Hello from backend");
        model.addAttribute("elements", Arrays.asList("elem1", "elem2", "elem3"));

        //dzięki adnotacji lomboka @Slf4j mamy log.
        //używamy do wyświetlania wiadomości \ logów
        log.info("wysłano stronę welcome-msg.html");
        //komentarz z ostrzeżeniem
        log.warn("");
        //wyświetlanie wyjątków, błędów
        log.error("");
        //szczegółowe informacje do błędów
        log.debug("");

        return "welcome-msg";
    }

}
