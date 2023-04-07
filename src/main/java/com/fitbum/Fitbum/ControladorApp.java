package com.fitbum.Fitbum;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorApp {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/layout")
    public String layout() {
        return "/layout";
    }
}
