package com.fitbum.Fitbum.controladores;


import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
@RequiredArgsConstructor

public class UsuarioController {

    @GetMapping("/nuevoUsuario")
    public String registro(){
        return "/rrhh/nuevoUsuario";}

}
