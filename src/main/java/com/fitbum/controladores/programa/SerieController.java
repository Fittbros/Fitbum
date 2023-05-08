package com.fitbum.controladores.programa;

import com.fitbum.entidades.programa.Serie;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.servicios.programas.SerieServicio;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class SerieController {
    @Autowired
    private SerieServicio service;
    @GetMapping("/series")
    @ResponseBody
    public List<Serie> listar()
    {
        return service.listartodos();
    }


}
