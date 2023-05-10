package com.fitbum.controladores.programa;

import com.fitbum.entidades.Menu;
import com.fitbum.servicios.MenuServicio;
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
@RequestMapping("/ejercicios")
public class EjerciciosController {
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
    @GetMapping("/edit/{id}")
    public String showMenuEdit(@PathVariable("id") Integer id, Model model) {

        Optional<Menu> menu = menuServicio.findById(id);
        if(menu.isPresent()){
            model.addAttribute("menu", menu.get());
        }
        else{
            // Si el cliente no existe, redirigir a una página de error o mostrar un mensaje de error
            return "error-page";
        }

        return "menu/menu-form";

    }
//    @PostMapping("/save")
//    public String saveMenu(Menu menu) {
//        MenuServicio.save(menu);
//        return "redirect:/menu/";
//    }

}
