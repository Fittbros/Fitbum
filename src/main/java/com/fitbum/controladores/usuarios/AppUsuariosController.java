package com.fitbum.controladores.usuarios;


import com.fitbum.controladores.AbstractController;
import com.fitbum.dto.UsuarioDto;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.repositorios.usuarios.UsuarioRepositorio;
import com.fitbum.servicios.MenuServicio;
import com.fitbum.servicios.usuarios.RoleService;
import com.fitbum.servicios.usuarios.UsuarioServicio;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class AppUsuariosController //extends AbstractController <UsuarioDto>
 {
     @Autowired

    private  UsuarioServicio service;
    @Autowired
 private MenuServicio menuServicio;

    private final RoleService roleService;
    protected final String pageNumbersAttributeKey = "pageNumbers";
    @Autowired
    private MenuServicio menuService;
    @Autowired
    private PasswordEncoder passwordEncoder;
     @Autowired
     private UsuarioRepositorio usuarioRepositorio;

    public AppUsuariosController(MenuServicio menuService, UsuarioServicio service, RoleService roleService) {
        super();
        this.service = service;
        this.roleService = roleService;
    }

//    @GetMapping("/usuarios/lista")
//    public String vistaHome( ModelMap interfazConPantalla){
//
//        String  userName = "no informado";
//        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
//        //Comprobamos si hay usuario logeado
//        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
//            userName = "anonimo@anonimo";
//        }
//        else {
//            userName = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
//        }
//        interfazConPantalla.addAttribute("menuList", this.menuService.getMenuForEmail(userName));
//        return "index";
//    }
    @GetMapping("/usuarios")
    public String vistaUsuarios(@RequestParam("page") Optional<Integer> page,
                                @RequestParam("size") Optional<Integer> size,
                                    ModelMap interfazConPantalla,Model  model){
        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", service);

        Integer pagina = 0;
        if (page.isPresent()) {
            pagina = page.get() -1;
        }
        Integer maxelementos = 10;
        if (size.isPresent()) {
            maxelementos = size.get();
        }
        model.addAttribute("pag", pagina);
        Page<Usuario> usuarioPage =
                this.buscarTodos(PageRequest.of(pagina,maxelementos));
        interfazConPantalla.addAttribute(pageNumbersAttributeKey,dameNumPaginas(usuarioPage));
        interfazConPantalla.addAttribute("listausuarios", usuarioPage);
        return "usuarios/index";
    }
     @GetMapping("/atletas")
     public String vistaAtletas(@RequestParam("page") Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size,
                                 ModelMap interfazConPantalla,Model  model){
         model.addAttribute("dataObject", menuServicio.findAll());
         model.addAttribute("usuario", service);

         Integer pagina = 0;
         if (page.isPresent()) {
             pagina = page.get() -1;
         }
         Integer maxelementos = 10;
         if (size.isPresent()) {
             maxelementos = size.get();
         }
         model.addAttribute("pag", pagina);
         Page<Usuario> usuarioPage =
                 this.buscarTodos(PageRequest.of(pagina,maxelementos));
         interfazConPantalla.addAttribute(pageNumbersAttributeKey,dameNumPaginas(usuarioPage));
         interfazConPantalla.addAttribute("listausuarios", usuarioPage);
         return "atletas/index";
     }
     protected List<Integer> dameNumPaginas(Page<Usuario>  obj){
         List<Integer> pageNumbers = new ArrayList<>();
         int totalPages = obj.getTotalPages();
         if (totalPages > 0) {
             pageNumbers = IntStream.rangeClosed(1, totalPages)
                     .boxed()
                     .collect(Collectors.toList());
         }
         return pageNumbers;
     }
     public Page<Usuario> buscarTodos(Pageable pageable){
         return  usuarioRepositorio.findAll(pageable);
     }

}
