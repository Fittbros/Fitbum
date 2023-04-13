package com.fitbum.Fitbum.controladores;


import com.fitbum.Fitbum.entidades.DetalleUsuario;
import com.fitbum.Fitbum.rrhh.models.Usuario;
import com.fitbum.Fitbum.rrhh.services.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
//import org.springframework.validation.BindingResult;


@Controller
@Log4j2
@RequiredArgsConstructor

public class UsuarioController {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/usuarios")
    @ResponseBody
    public List<DetalleUsuario> getAll(){
        return usuarioServicio.getAll();
    }

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
