package pl.sda.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.model.User;
import pl.sda.service.AutoLoginService;
import pl.sda.service.UserService;

@Slf4j
@Controller
public class RegistrationController {

    private final UserService userService;

    private final AutoLoginService autoLoginService;

    public RegistrationController(UserService userService, AutoLoginService autoLoginService) {
        this.userService = userService;
        this.autoLoginService = autoLoginService;
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String register(@ModelAttribute User user) {

        log.info("Receive user to register: " + user);

        if (userService.existsByUsername(user.getUsername())) {
            log.warn("User with username " + user.getUsername() + " exists!");
            return "registration";
        }

        userService.save(user);

        log.info("Registered successfully user with username " + user.getUsername());

        autoLoginService.autoLogin(user.getUsername(), user.getPassword());

        return "redirect:/books";

    }
}
