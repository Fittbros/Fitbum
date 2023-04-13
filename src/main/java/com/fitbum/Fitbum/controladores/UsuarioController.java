package com.fitbum.Fitbum.controladores;


import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;


@Controller
@Log4j2
@RequiredArgsConstructor

public class UsuarioController {

    @GetMapping("/nuevoUsuario")
    public String registro(){
        return "/formularios/nuevoUsuario";}

    @GetMapping("/olvideContrasena")
    public String formularioOlvideContrasena(){
        return "/formularios/olvideContrasena";}

    @GetMapping("/perfil")
    public String perfil(){
        return "/rrhh/perfil";}
}
