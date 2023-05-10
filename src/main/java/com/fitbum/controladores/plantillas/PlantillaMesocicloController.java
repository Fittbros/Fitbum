


package com.fitbum.controladores.plantillas;

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
@RequestMapping("/plantillas")
public class PlantillaMesocicloController {
    @Autowired
    private MenuServicio menuServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;
    @GetMapping(value = {"/",""})
    public String showMenu(
            Model model
    ) {

        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);


//        model.addAttribute("fragmentName", "fragment-customer-list");

        return "/plantillas/index";
    }
    @GetMapping(value = {"/meso"})
    public String plantMeso(
            Model model
    ) {
        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        return "/plantillas/mesociclo";
    }
    @GetMapping(value = {"/micro"})
    public String plantMicro(
            Model model
    ) {
        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        return "/plantillas/microciclo";
    }
    @GetMapping(value = {"/ejercicio"})
    public String plantejercicio(
            Model model
    ) {
        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        return "/plantillas/ejercicio";
    }
    @GetMapping(value = {"/sesion"})
    public String plantsesion(
            Model model
    ) {
        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        return "/plantillas/sesion";
    }
    @GetMapping(value = {"/serie"})
    public String plantserie(
            Model model
    ) {
        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        return "/plantillas/serie";
    }
}
