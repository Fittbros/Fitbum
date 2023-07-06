package com.fitbum.controladores.usuarios;


import com.fitbum.controladores.AbstractController;
import com.fitbum.dto.LoginDto;
import com.fitbum.dto.RoleDTO;
import com.fitbum.dto.UsuarioDtoPsw;
import com.fitbum.dto.UsuarioDto;
import com.fitbum.entidades.usuarios.Role;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.filemanagement.models.FileInfo;
import com.fitbum.filemanagement.servicios.FileSystemStorageService;
import com.fitbum.servicios.MenuServicio;
import com.fitbum.servicios.usuarios.IUsuarioServicio;
import com.fitbum.servicios.usuarios.RoleService;
import com.fitbum.servicios.usuarios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

import static com.fitbum.util.ValidarFormatoPassword.ValidarFormato;
//import org.springframework.validation.BindingResult;


@Controller
@Log4j2
@RequestMapping("usuarios")

public class UsuarioController //extends AbstractController<Usuario>
{

    @Autowired
    private UsuarioServicio service;

    @Autowired
    private RoleService roleService;

    @Autowired
    private IUsuarioServicio userService;
    @Autowired
    private MenuServicio menuServicio;
    @Autowired
    private FileSystemStorageService fileSystemStorageService;

    @GetMapping("registro")
    public String vistaRegistro(Model interfazConPantalla) {
        //Instancia en memoria del dto a informar en la pantalla
        final UsuarioDtoPsw usuarioDtoPsw = new UsuarioDtoPsw();
        //Obtengo la lista de roles
        final List<RoleDTO> roleDTOList = roleService.buscarTodos();
        //Mediante "addAttribute" comparto con la pantalla

        interfazConPantalla.addAttribute("datosUsuario",usuarioDtoPsw);

        interfazConPantalla.addAttribute("listaRoles",roleDTOList);
        return "formularios/nuevoUsuario";
    }
        //Mediante "addAttribute" comparto con la pantalla




    //El que con los datos de la pantalla guarda la informacion de tipo PostMapping
    @PostMapping("registro")
    public String guardarUsuario( @ModelAttribute(name ="datosUsuario") UsuarioDtoPsw usuarioDtoPsw) throws Exception {
        //Comprobamos el patron
        System.out.println("Guardando usuario antes ");
        System.out.println("Usuario :" + usuarioDtoPsw.getUsername() + ", password : " + usuarioDtoPsw.getPassword() );
        if (ValidarFormato(usuarioDtoPsw.getPassword())){
            Usuario usuario = service.getMapper().mapToUserPsw(usuarioDtoPsw);
            System.out.println("Guardando usuario");
            System.out.println("Usuario :" + usuario.getNombre() + ", password : " + usuario.getPassword() );
            //Codifico la password
            String encodedPasswod = userService.getEncodedPassword(usuario);
            usuarioDtoPsw.setPassword(encodedPasswod);
            System.out.println("la pssw codif es "+usuarioDtoPsw.getPassword());
            //El usuario se guarda como no autorizado
            //Guardo la password
            Optional<Role> role= roleService.buscar(3);
            if(role.isPresent())
            {
                usuarioDtoPsw.setRole(role.get());
            }
            usuarioDtoPsw.setActive(true);
            UsuarioDto usuario1 = this.service.guardar(usuarioDtoPsw);
            //return "usuarios/detallesusuario";
            return "redirect:/usuarios/login";
        }
        else
        {
            return "formularios/nuevoUsuario";
        }
    }


@PostMapping("savepass")
public String savePass(Usuario usuario, Model model) {
    model.addAttribute("dataObject", menuServicio.findAll());
    model.addAttribute("usuario", service);
    String encodedPasswod = userService.getEncodedPassword(usuario);
    usuario.setPassword(encodedPasswod);

    service.getRepo().save(usuario);

    return "redirect:/usuarios";
}

    @GetMapping("olvidecontrasena")
    public String formularioOlvideContrasena(){

        return "formularios/olvidecontrasena";}

    @GetMapping("/perfil/{id}")
//    @PreAuthorize("authentication.principal.username==usuario.username")
    public String perfil(@PathVariable("id") Integer id,
                         Model model, Authentication authentication
    ){
        model.addAttribute("usuario", service);
        String username = authentication.getName();
        System.out.println(username);
        Optional<Usuario> usuario = service.getRepo().findById(id);
        if(usuario.isPresent()){
            System.out.println(usuario.get());
            model.addAttribute("logeduser",usuario.get());}

        else{
            return "error";
        }
        model.addAttribute("dataObject", menuServicio.getMenuForUsername(username));
        List<FileInfo> files = fileSystemStorageService.loadAll();
        model.addAttribute("files", files);
        return "rrhh/perfil";}
    @GetMapping("/editpass/{id}")
    public String cambiopass(@PathVariable("id") Integer id,
                         Model model, Authentication authentication
    ){
        model.addAttribute("usuario", service);
        String username = authentication.getName();
        System.out.println(username);
        Optional<Usuario> usuario = service.getRepo().findById(id);
        if(usuario.isPresent()){
            System.out.println(usuario.get());
            model.addAttribute("logeduser",usuario.get());}
        else{
            return "error";
        }
        List<FileInfo> files = fileSystemStorageService.loadAll();
        model.addAttribute("dataObject", menuServicio.getMenuForUsername(username));

        model.addAttribute("files", files);
        return "rrhh/cambioPass";}
    @PostMapping("usuarios/save")
    public String savePerfil(Usuario usuario, Model model) {
        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", service);
        service.getRepo().save(usuario);

        return "redirect:/usuarios";
    }

}

