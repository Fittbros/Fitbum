


package com.fitbum.controladores.plantillas;

import com.fitbum.entidades.plantillas.PlantillaMesociclo;
import com.fitbum.entidades.tutoriales.Ejercicios;
import com.fitbum.repositorios.plantillas.PlantMesoRepositorio;
import com.fitbum.servicios.MenuServicio;
import com.fitbum.servicios.plantillas.*;
import com.fitbum.servicios.usuarios.UsuarioServicio;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@Log4j2
@RequestMapping("/plantillas")
public class PlantillaMesocicloController {
    @Autowired
    private MenuServicio menuServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private PlantMesoRepositorio plantMesoRepositorio;
    @Autowired
    private MesoService mesoService;
    @Autowired
    private MicroService microService;
    @Autowired
    private SesionService sesionService;
    @Autowired
    private SerieService serieService;
    @Autowired
    private EjFService ejFService;
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
        model.addAttribute("meso", plantMesoRepositorio.findAll());

        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        return "/plantillas/mesociclo";
    }
    @GetMapping("/meso/{id}")
    public String showMesoId(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        model.addAttribute("id", id);

        Optional<PlantillaMesociclo> meso= mesoService.findById(id);
        model.addAttribute("micro", microService.findAll());
        model.addAttribute("sesion", sesionService.findAll());
        model.addAttribute("ej", ejFService.findAll());
        model.addAttribute("serie", serieService.findAll());
//
////        Optional<PlantillaMesociclo> meso = mesoService.findById(id);
        if(meso.isPresent()){
            model.addAttribute("meso", meso);

        }
        else{
//            return "plantillas/meso";


            // Si el cliente no existe, redirigir a una página de error o mostrar un mensaje de error
            return "error-page";
        }

        return "plantillas/mesoId";

    }
    @GetMapping(value = {"/micro"})
    public String plantMicro(
            Model model
    ) {
        model.addAttribute("micro", microService.findAll());

        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        return "/plantillas/microciclo";
    }
    @GetMapping(value = {"/ejercicio"})
    public String plantejercicio(
            Model model
    ) {
        model.addAttribute("ej", ejFService.findAll());

        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        return "/plantillas/ejercicio";
    }
    @GetMapping(value = {"/sesion"})
    public String plantsesion(
            Model model
    ) {
        model.addAttribute("sesion", sesionService.findAll());
        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        return "/plantillas/sesion";
    }
    @GetMapping(value = {"/serie"})
    public String plantserie(
            Model model
    ) {
        model.addAttribute("serie", serieService.findAll());

        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        return "/plantillas/serie";
    }
}
