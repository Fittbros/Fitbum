package com.fitbum.controladores.programa;

import com.fitbum.entidades.programa.Sesion;
import com.fitbum.servicios.programas.SesionServicio;
import groovy.transform.AutoImplement;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor


public class SesionController {
    @Autowired
    private SesionServicio service;
    @GetMapping("/sesiones")
    @ResponseBody
    public List<Sesion> listar(){
        return service.listartodos();
    }




}
