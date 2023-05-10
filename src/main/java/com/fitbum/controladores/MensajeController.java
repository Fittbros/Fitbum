package com.fitbum.controladores;
import com.fitbum.servicios.MenuServicio;
import com.fitbum.servicios.usuarios.UsuarioServicio;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Log4j2
@RequestMapping("/chat")

public class MensajeController {

    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private MenuServicio menuServicio;
    @GetMapping(value = {"/",""})
    public String indexchat(Model model
    ) {
        model.addAttribute("usuario", usuarioServicio);
        model.addAttribute("dataObject", menuServicio.findAll());
        return "/chat/index";}

    @GetMapping(value = {"/entrenador"})
    public String chatentrenador(Model model
    ) {
        model.addAttribute("usuario", usuarioServicio);
        model.addAttribute("dataObject", menuServicio.findAll());
        return "/chat/chatEntrenador";}

    @GetMapping(value = {"/atletas"})
    public String chatatletas(Model model
    ) {
        model.addAttribute("usuario", usuarioServicio);
        model.addAttribute("dataObject", menuServicio.findAll());
        return "/chat/chatAtletas";}

}
