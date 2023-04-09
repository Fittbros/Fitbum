package com.fitbum.Fitbum;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorApp {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/_layout")
    public String layout() {
        return "_layout";
    }
    @GetMapping("/layout-login")
    public String layoutLogin() {
        return "layout-login";
    }
}
