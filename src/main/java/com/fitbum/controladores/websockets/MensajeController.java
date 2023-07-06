package com.fitbum.controladores.websockets;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.servicios.MenuServicio;
import com.fitbum.servicios.usuarios.UsuarioServicio;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;


@Controller
@Log4j2
@RequestMapping("/chat")

public class MensajeController {

    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private MenuServicio menuServicio;
    @GetMapping(value = {"/",""})
    public String indexchat(Model model, Authentication authentication
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
        return "/chat/index";}

    @GetMapping(value = {"/entrenador"})
    public String chatentrenador(Model model, Authentication authentication
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
        return "/chat/chatEntrenador";}

    @GetMapping(value = {"/atletas"})
    public String chatatletas(Model model, Authentication authentication
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
        return "/chat/chatAtletas";}

    @GetMapping(value = {"/chatprueba"})
    public String chatprueba(Principal principal, Model model, Authentication authentication
    ) {
        String username = authentication.getName();
        Optional<Usuario> usuario = Optional.ofNullable(usuarioServicio.getRepo().findUsuarioByUsername(username));
        if(usuario.isPresent()){
            model.addAttribute("logeduser",usuario.get());}
        else{
            return "error";
        }
        model.addAttribute("dataObject", menuServicio.getMenuForUsername(username));
        String userID = principal.getName();
        model.addAttribute("userID", userID);
        model.addAttribute("usuario", usuarioServicio);
        return "/chat/chatprueba";}

    @GetMapping(value = {"/chatprueba3"})
    public String chatprueba3 (Principal principal, Model model, Authentication authentication
    ) {
        String username = authentication.getName();
        Optional<Usuario> usuario = Optional.ofNullable(usuarioServicio.getRepo().findUsuarioByUsername(username));
        if(usuario.isPresent()){
            model.addAttribute("logeduser",usuario.get());}
        else{
            return "error";
        }
        model.addAttribute("dataObject", menuServicio.getMenuForUsername(username));
        String userID = principal.getName();
        model.addAttribute("userID", userID);
        model.addAttribute("usuario", usuarioServicio);
        return "/chat/chatprueba3";}

}
