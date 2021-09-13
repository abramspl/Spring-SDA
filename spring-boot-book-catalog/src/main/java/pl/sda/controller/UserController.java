package pl.sda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user/panel")
    public String userPanel() {
        return "user-panel";
    }
}
