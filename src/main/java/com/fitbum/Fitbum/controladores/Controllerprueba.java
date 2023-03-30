package com.fitbum.Fitbum.controladores;

import com.fitbum.Fitbum.entidades.DetalleUsuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
//@RequestMapping("/prueba")
public class Controllerprueba {

        @GetMapping("/prueba")
        public String prueba(){
            return "pruebadocker";

        }
    @GetMapping("/signup")
    public String showSignUpForm(DetalleUsuario usuario) {
        return "adduser";
    }

    }


