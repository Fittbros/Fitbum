package com.fitbum.controladores.usuarios;


import com.fitbum.entidades.usuarios.DetalleUsuario;
import com.fitbum.servicios.usuarios.DetallesServicio;
import com.fitbum.servicios.usuarios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
    @Autowired
    private DetallesServicio detallesServicio;

    @GetMapping("/usuarios")
    @ResponseBody
    public List<DetalleUsuario> getAll(){
        return usuarioServicio.getAll();
    }

    @GetMapping("/nuevoUsuario")
    public String registro(Model model){
        model.addAttribute("detalleUsuario", new DetalleUsuario());
        return "/formularios/nuevoUsuario";}

    @GetMapping("/crearUsuario")
    public String crearUsuario(DetalleUsuario detalleUsuario){
        detallesServicio.crearUsuario(detalleUsuario);
        return "/formularios/login";
    }

    @GetMapping("/olvideContrasena")
    public String formularioOlvideContrasena(){
        return "/formularios/olvideContrasena";}

    @GetMapping("/perfil")
    public String perfil(){
        return "/rrhh/perfil";}


}
