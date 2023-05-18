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
import org.springframework.security.core.Authentication;
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
                                    ModelMap interfazConPantalla,Model model, Authentication authentication
    ) {
        String username = authentication.getName();
        Optional<Usuario> usuario = Optional.ofNullable(service.getRepo().findUsuarioByUsername(username));
        if(usuario.isPresent()){
            model.addAttribute("logeduser",usuario.get());}
        else{
            return "error";
        }
        model.addAttribute("dataObject", menuServicio.getMenuForUsername(username));
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
     @GetMapping("/usuarios/buscar")
     public String buscarUsuarios(@RequestParam("query") String query,@RequestParam("page") Optional<Integer> page,
                                  @RequestParam("size") Optional<Integer> size,
                                  ModelMap interfazConPantalla,Model model, Authentication authentication
     ) {
         String username = authentication.getName();
         Optional<Usuario> usuario = Optional.ofNullable(service.getRepo().findUsuarioByUsername(username));
         if(usuario.isPresent()){
             model.addAttribute("logeduser",usuario.get());}
         else{
             return "error";
         }
         model.addAttribute("dataObject", menuServicio.getMenuForUsername(username));
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
         // Lógica para buscar usuarios según la consulta "query"
         List<Usuario> usuariosEncontrados = buscarUsuarios(query);

         model.addAttribute("usuarios", usuariosEncontrados);
         return "/usuarios/resbusqueda";
     }
     public List<Usuario> buscarUsuarios(String query) {
         // Lógica para buscar usuarios según la consulta "query"
         // Aquí puedes realizar consultas en tu base de datos o buscar en la lista de usuarios existente

         // Ejemplo de búsqueda en una lista de usuarios existente
         List<Usuario> todosLosUsuarios = usuarioRepositorio.findAll();
         List<Usuario> usuariosEncontrados = new ArrayList<>();

         for (Usuario usuario : todosLosUsuarios) {
             // Verifica si la consulta coincide con algún campo del usuario
             if (usuario.getNombre().contains(query) ||
                     usuario.getApellido1().contains(query) ||
                     usuario.getApellido2().contains(query) ||
                     usuario.getUsername().contains(query) ||
                     usuario.getEmail().contains(query)) {
                 usuariosEncontrados.add(usuario);
             }
         }

         return usuariosEncontrados;
     }


     @GetMapping("/atletas")
     public String vistaAtletas(@RequestParam("page") Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size,
                                 ModelMap interfazConPantalla,Model model, Authentication authentication
     ) {
         String username = authentication.getName();
         Optional<Usuario> usuario = Optional.ofNullable(service.getRepo().findUsuarioByUsername(username));
         if(usuario.isPresent()){
             model.addAttribute("logeduser",usuario.get());}
         else{
             return "error";
         }
         model.addAttribute("dataObject", menuServicio.getMenuForUsername(username));
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
