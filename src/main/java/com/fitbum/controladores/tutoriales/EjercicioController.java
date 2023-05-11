package com.fitbum.controladores.tutoriales;

import com.fitbum.entidades.Menu;
import com.fitbum.entidades.tutoriales.ContentTutorial;
import com.fitbum.entidades.tutoriales.Ejercicios;
import com.fitbum.repositorios.programa.EjerciciosRepositorio;
import com.fitbum.repositorios.tutoriales.ContentTutorialRepositorio;
import com.fitbum.servicios.MenuServicio;
import com.fitbum.servicios.tutoriales.EjerciciosServicio;
import com.fitbum.servicios.usuarios.UsuarioServicio;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;


@Controller
@Log4j2
@RequestMapping("/ejercicios")

public class EjercicioController {
    @Autowired
    private MenuServicio menuServicio;
    @Autowired
    private EjerciciosServicio ejerciciosServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private EjerciciosRepositorio  ejerciciosRepositorio;
    @Autowired
    private ContentTutorialRepositorio contentTutorialRepositorio;

    @GetMapping(value = {"/",""})
    public String showindex(
    Model model
    ) {
        model.addAttribute("ejercicios", ejerciciosRepositorio.findAll());

        model.addAttribute("usuario", usuarioServicio);
        model.addAttribute("dataObject", menuServicio.findAll());
        return "ejercicios/index";
    }

    @GetMapping("/{id}")
    public String showEjEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);

        Optional<Ejercicios> ej = ejerciciosServicio.findById(id);
        if(ej.isPresent()){
            model.addAttribute("ej", ej.get());
        }
        else{

            // Si el cliente no existe, redirigir a una página de error o mostrar un mensaje de error
            return "error";
        }

        return "ejercicios/ej-form";

    }
    @GetMapping("/nuevo")
    public String showEjNew(Model model) {
        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        Ejercicios ejercicionuevo = new Ejercicios();
        Integer id =ejerciciosRepositorio.findAll().size()+1;
        ejercicionuevo.setId(id);
        ejerciciosServicio.save(ejercicionuevo);
        Optional<Ejercicios> ej = ejerciciosServicio.findById(id);
        if(ej.isPresent()){
            model.addAttribute("ej", ej.get());
        }
        else{
            return "error";
        }
        return "ejercicios/ej-formnuevo";
    }

    @PostMapping("/save")
    public String saveEj(Ejercicios ejercicio, Model model) {
        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        ejerciciosServicio.save(ejercicio);

        return "redirect:/ejercicios";
    }

}
