package com.fitbum.controladores.usuarios;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class LoginController {
    @GetMapping("/login")
    public String showLogin()
    {
        return "/formularios/login";
    }
}
