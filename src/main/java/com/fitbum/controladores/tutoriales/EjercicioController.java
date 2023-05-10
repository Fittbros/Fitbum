package com.fitbum.controladores.tutoriales;

import com.fitbum.entidades.Menu;
import com.fitbum.entidades.tutoriales.Ejercicios;
import com.fitbum.repositorios.programa.EjerciciosRepositorio;
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

    @GetMapping(value = {"/",""})
    public String showindex(
    Model model
    ) {
        model.addAttribute("ej",ejerciciosServicio);
        model.addAttribute("usuario", usuarioServicio);
        model.addAttribute("dataObject", menuServicio.findAll());
        return "ejercicios/index";
    }
    @GetMapping("/2")
    public String show2(Model model){
        model.addAttribute("ejercicios", ejerciciosRepositorio.findAll());
//        ejerciciosServicio.findAll();
        model.addAttribute("usuario", usuarioServicio);
        model.addAttribute("dataObject", menuServicio.findAll());

        return "ejercicios/2";
    }
    @GetMapping("/edit/{id}")
    public String showEjEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);

        Optional<Ejercicios> ej = ejerciciosServicio.findById(id);
        if(ej.isPresent()){
            model.addAttribute("ej", ej.get());
        }
        else{

            // Si el cliente no existe, redirigir a una página de error o mostrar un mensaje de error
            return "error-page";
        }

        return "ejercicios/ej-form";

    }
//    @PostMapping("/save")
//    public String saveMenu(Menu menu) {
//        MenuServicio.save(menu);
//        return "redirect:/menu/";
//    }

}
