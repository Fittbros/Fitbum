package com.fitbum.controladores.tutoriales;

import com.fitbum.entidades.Menu;
import com.fitbum.entidades.tutoriales.ContentTutorial;
import com.fitbum.entidades.tutoriales.Ejercicios;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.repositorios.programa.EjerciciosRepositorio;
import com.fitbum.repositorios.tutoriales.ContentTutorialRepositorio;
import com.fitbum.servicios.MenuServicio;
import com.fitbum.servicios.tutoriales.EjerciciosServicio;
import com.fitbum.servicios.usuarios.UsuarioServicio;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
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
    @Autowired
    private ContentTutorialRepositorio contentTutorialRepositorio;
    protected final String pageNumbersAttributeKey = "pageNumbers";


    @GetMapping(value = {"/",""})
    public String showindex(
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size,
            ModelMap interfazConPantalla, Model model, Authentication authentication
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

        Integer pagina = 0;
        if (page.isPresent()) {
            pagina = page.get() -1;
        }
        Integer maxelementos = 10;
        if (size.isPresent()) {
            maxelementos = size.get();
        }
        model.addAttribute("pag", pagina);
        Page<Ejercicios> usuarioPage =
                this.buscarTodos(PageRequest.of(pagina,maxelementos));
        interfazConPantalla.addAttribute(pageNumbersAttributeKey,dameNumPaginas(usuarioPage));
        interfazConPantalla.addAttribute("listausuarios", usuarioPage);
        return "ejercicios/index";
    }
    protected List<Integer> dameNumPaginas(Page<Ejercicios>  obj){
        List<Integer> pageNumbers = new ArrayList<>();
        int totalPages = obj.getTotalPages();
        if (totalPages > 0) {
            pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
        }
        return pageNumbers;
    }
    public Page<Ejercicios> buscarTodos(Pageable pageable){
        return  ejerciciosRepositorio.findAll(pageable);
    }
//
//    Model model
//    ) {
//        model.addAttribute("ejercicios", ejerciciosRepositorio.findAll());
//
//        model.addAttribute("usuario", usuarioServicio);
//        model.addAttribute("dataObject", menuServicio.findAll());
//        return "ejercicios/index";
//    }

    @GetMapping("/{id}")
    public String showEjEdit(@PathVariable("id") Integer id, Model model, Authentication authentication
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

        Optional<Ejercicios> ej = ejerciciosServicio.findById(id);
        if(ej.isPresent()){
            model.addAttribute("ej", ej.get());
        }
        else{

            // Si el cliente no existe, redirigir a una página de error o mostrar un mensaje de error
            return "error";
        }

        return "ejercicios/ej-form";

    }
    @GetMapping("/nuevo")
    public String showEjNew(Model model, Authentication authentication
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
        Ejercicios ejercicionuevo = new Ejercicios();
        Integer id =ejerciciosRepositorio.findAll().size()+1;
        ejercicionuevo.setId(id);
        ejerciciosServicio.save(ejercicionuevo);
        Optional<Ejercicios> ej = ejerciciosServicio.findById(id);
        if(ej.isPresent()){
            model.addAttribute("ej", ej.get());
        }
        else{
            return "error";
        }
        return "ejercicios/ej-formnuevo";
    }

    @PostMapping("/save")
    public String saveEj(Ejercicios ejercicio, Model model) {
        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        ejerciciosServicio.save(ejercicio);

        return "redirect:/ejercicios";
    }

}
