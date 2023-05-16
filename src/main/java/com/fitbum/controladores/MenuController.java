package com.fitbum.controladores;
import com.fitbum.dto.UsuarioDto;
import com.fitbum.entidades.Menu;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.repositorios.MenuRepositorio;
import com.fitbum.servicios.MenuServicio;
import com.fitbum.servicios.usuarios.UsuarioServicio;
import com.fitbum.util.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;


@Controller
@Log4j2
@RequestMapping("/menu")


public class MenuController //extends  AbstractController<UsuarioDto>
{
    @Autowired
    private MenuServicio menuServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;
//    protected MenuController (MenuServicio menuService) {
//        super(menuService);
//    }
    @GetMapping(value = {"/",""})
    public String showMenu(
            Model model, Authentication authentication
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



//        model.addAttribute("fragmentName", "fragment-customer-list");

        return "/menu/index";
    }
@GetMapping("/2")
public String menu2(Model model, Authentication authentication
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
        return "/menu/2";
}
    @GetMapping("/3")
    public String menu3( Model model, Authentication authentication
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
//        model.addAttribute("prueba", SecurityContextHolder.getContext().getAuthentication().getPrincipal());


//        model.addAttribute("fragmentName", "fragment-customer-list");
        return "/menu/3";
    }
    @GetMapping(value = {"/indere"})
    public String showMenu2(Model model, Authentication authentication
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

//        model.addAttribute("fragmentName", "fragment-customer-list");

        return "menu/indere";
    }
    @GetMapping("/reorg")
    public String reorg(Model model, Authentication authentication
    ) {
        String username = authentication.getName();
        Optional<Usuario> usuario = Optional.ofNullable(usuarioServicio.getRepo().findUsuarioByUsername(username));
        if(usuario.isPresent()){
            model.addAttribute("logeduser",usuario.get());}
        else{
            return "error";
        }
        model.addAttribute("dataObject", menuServicio.getMenuForUsername(username));


//        model.addAttribute("menu", menuServicio.findAll());
//        model.addAttribute("usuario", usuarioServicio);
        return "/menu/reorg";
    }
    @GetMapping("/edit/{id}")
    public String showMenuEdit(@PathVariable("id") Integer id, Model model, Authentication authentication
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

        Optional<Menu> menu = menuServicio.findById(id);
        if(menu.isPresent()){
            model.addAttribute("menu", menu.get());
        }
        else{
            // Si el cliente no existe, redirigir a una página de error o mostrar un mensaje de error

            return "error";
        }

        return "menu/menu-form";

    }
    @PostMapping("/save")
    public String saveMenu(Menu menu, Model model) {
        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        menuServicio.save(menu);
        return "redirect:/menu";
    }

}
