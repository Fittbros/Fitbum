package com.fitbum.controladores.usuarios;

import com.fitbum.dto.LoginDto;
import com.fitbum.servicios.usuarios.UsuarioServicio;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class LoginController {
    //Controlador de Login
    private final UsuarioServicio service;
    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
    private PasswordEncoder passwordEncoder;
    public LoginController(UsuarioServicio service) {
        this.service = service;
    }

    @GetMapping("/usuarios/login")
    public String vistaLogin(){
        return "formularios/login";
    }
    @PostMapping("/usuarios/login")
    public String validarPasswordPst(@ModelAttribute(name = "loginForm" ) LoginDto loginDto) {
        String usr = loginDto.getUsername();
        System.out.println("usr :" + usr);
        String password = loginDto.getPassword();
        System.out.println("pass :" + password);
        //¿es correcta la password?
        if (service.getUsuarioRepositorio().repValidarPassword(usr, passwordEncoder.encode(password) ) > 0)
        {
            return "index";
        }else {
            return "formularios/login";
        }
    }


    @GetMapping("/usuarios/login-error")
    public String login(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        String errorMessage = null;
        if (session != null) {
            AuthenticationException ex = (AuthenticationException) session
                    .getAttribute(  WebAttributes.AUTHENTICATION_EXCEPTION);
            if (ex != null) {
                errorMessage = ex.getMessage() ;
            }
        }
        model.addAttribute("errorMessage", errorMessage);
        return "formularios/login";
    }
}
