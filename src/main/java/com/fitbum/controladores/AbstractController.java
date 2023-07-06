package com.fitbum.controladores;


import com.fitbum.dto.MenuDTO;
import com.fitbum.servicios.MenuServicio;
import com.fitbum.servicios.usuarios.UsuarioServicio;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
@Controller
//Esta clase abstracta admite cualuiertipode objeto DTO o entidad
public abstract class AbstractController<OBJ> {

    MenuServicio menuService;
    UsuarioServicio usuarioServicioInterno;

    protected AbstractController(MenuServicio menuService) {
        this.menuService = menuService;
    }
    protected final String pageNumbersAttributeKey = "pageNumbers";
    protected List<Integer> dameNumPaginas(Page<OBJ>  obj){
        List<Integer> pageNumbers = new ArrayList<>();
        int totalPages = obj.getTotalPages();
        if (totalPages > 0) {
            pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
        }
        return pageNumbers;
    }
    @ModelAttribute("menuList")
    public List<MenuDTO> menu() {
        String  userName = "no informado";
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        //Comprobamos si hay usuario logeado
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            userName = "anonimo@anonimo";
        }
        else {
            userName = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        }
        return this.menuService.getMenuForEmail(userName);
    }
    @ModelAttribute ("imagenusuario")
    public String obtenerimagenUsuario() {
        String userName= "";
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            userName = "anonimo@anonimo";
        }
        else {

            userName = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        }
        return this.usuarioServicioInterno.getRepo().findUsuarioByUsername(userName).getAvatar();
    }
}
