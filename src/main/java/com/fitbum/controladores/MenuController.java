package com.fitbum.controladores;
import com.fitbum.repositorios.MenuRepositorio;
import com.fitbum.servicios.MenuServicio;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Log4j2
@RequiredArgsConstructor


public class MenuController {
    @Autowired
    private MenuServicio menuServicio;
    @GetMapping(value = {"/menu"})
    public String showMenu(
            Model model
    ) {
        model.addAttribute("dataObject", menuServicio.findAll());
//        model.addAttribute("fragmentName", "fragment-customer-list");

        return "/menu/index";
    }

}
