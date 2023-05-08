
package com.fitbum.controladores.programa;
import com.fitbum.entidades.programa.Microciclo;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.servicios.programas.MicrocicloServicio;
import com.fitbum.servicios.usuarios.IUsuarioServicio;
import jakarta.persistence.*;
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

public class MicrocicloController {
    @Autowired
    private MicrocicloServicio service;

    @GetMapping("/microciclos")
    @ResponseBody
    public List<Microciclo> listar() {
        return service.listartodos();
    }



}
