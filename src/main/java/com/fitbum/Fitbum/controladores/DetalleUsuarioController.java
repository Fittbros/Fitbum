package com.fitbum.Fitbum.controladores;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/detalleUsuario")

public class DetalleUsuarioController {

    @GetMapping("/perfil")
    public String perfil(){
        return "/rrhh/perfil";}

}
