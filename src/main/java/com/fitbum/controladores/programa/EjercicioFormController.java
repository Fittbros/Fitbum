package com.fitbum.controladores.programa;
import com.fitbum.entidades.programa.EjercicioForm;
import com.fitbum.servicios.programas.EjercicioFormServicio;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor

public class EjercicioFormController {
    @Autowired
    private EjercicioFormServicio service;
    @GetMapping("/ejerciciosForm")
    @ResponseBody
    public List<EjercicioForm> listar(){
        return service.listartodos();
    }
}

