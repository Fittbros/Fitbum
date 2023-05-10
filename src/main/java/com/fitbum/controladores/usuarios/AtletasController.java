package com.fitbum.controladores.usuarios;

import com.fitbum.servicios.MenuServicio;
import com.fitbum.servicios.usuarios.UsuarioServicio;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/atletas")
public class AtletasController {
    @Autowired
    private MenuServicio menuServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;
    @GetMapping(value = {"/",""})
    public String index(Model model
    ) {

        model.addAttribute("usuario", usuarioServicio);
        model.addAttribute("dataObject", menuServicio.findAll());
        return "atletas/index";
    }
}
