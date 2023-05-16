package com.fitbum.controladores.usuarios;

import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.servicios.MenuServicio;
import com.fitbum.servicios.usuarios.UsuarioServicio;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@Log4j2
@RequestMapping("/entrenadores")
public class EntrenadoresController {
    @Autowired
    private MenuServicio menuServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;
    @GetMapping(value = {"/",""})
    public String index(Model model, Authentication authentication
    ) {
        String username = authentication.getName();
        Optional<Usuario> usuario = Optional.ofNullable(usuarioServicio.getRepo().findUsuarioByUsername(username));
        if(usuario.isPresent()){
            model.addAttribute("logeduser",usuario.get());}
        else{
            return "error";
        }
        model.addAttribute("dataObject", menuServicio.getMenuForUsername(username));

        model.addAttribute("usuario", usuarioServicio);

        return "entrenadores/index";
    }
}
