package com.fitbum.Fitbum;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorApp {

    @GetMapping("/index")
    public String indexhome() {
        return "/index";
    }

    @GetMapping("/layout")
    public String home() {
        return "/layout";
    }
}
