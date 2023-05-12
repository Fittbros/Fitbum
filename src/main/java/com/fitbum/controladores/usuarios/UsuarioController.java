package com.fitbum.controladores.usuarios;


import com.fitbum.controladores.AbstractController;
import com.fitbum.dto.LoginDto;
import com.fitbum.dto.RoleDTO;
import com.fitbum.dto.UsuarioDtoPsw;
import com.fitbum.dto.UsuarioDto;
import com.fitbum.entidades.usuarios.Role;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.servicios.MenuServicio;
import com.fitbum.servicios.usuarios.IUsuarioServicio;
import com.fitbum.servicios.usuarios.RoleService;
import com.fitbum.servicios.usuarios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @GetMapping(value = {"/",""})
//    public String index(Model model
//    ) {
//
//        model.addAttribute("usuario", service);
//        model.addAttribute("dataObject", menuServicio.findAll());
//        return "usuarios/index";
//    } movido a APPusuarioscontroles

//    protected UsuarioController(MenuServicio menuService) {
//        super(menuService);
//    }



//    @GetMapping("/usuarios")
//    @ResponseBody
//    public List<Usuario> listar(Model model
//    ) {
//        model.addAttribute("dataObject", menuServicio.findAll());
//        return service.listartodos();
//    }

    //Para crear un usuario hay dos bloques
    //El que genera la pantalla para pedir los datos de tipo GetMapping
    //Cuando pasamos informacion a la pantalla hay que usar ModelMap
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
//    @GetMapping("/registrar")
//    public String crearUsuario(Usuario usuario){
//        service.crearUsuario(usuario);
//        return "/formularios/registrar";
//    }
//    @GetMapping("/registrar2")
//    public String vistaReg(){
//        return "/formularios/registrar";
//    }
//    @PostMapping("/registrar2")
//    public String registrar(@ModelAttribute(name = "datosUsuario" ) Usuario loginDto) {
//        String usr = loginDto.getUsername();
//        System.out.println("usr :" + usr);
//        String password = loginDto.getPassword();
//        System.out.println("pass :" + password);
//        //¿es correcta la password?
////        if (service.getUsuarioRepositorio().repValidarPassword(usr, passwordEncoder.encode(password) ) > 0)
////        {
//            return "home";
////        }else {
////            return "formularios/registrar";
////        }
//    }
////    @GetMapping("/registrar2")
////
////    public String registro(Model model){
////        model.addAttribute("datosUsuario", new Usuario() usuario);
////        service.crearUsuario(usuario);
////        return "/formularios/registrar";}


    @GetMapping("olvidecontrasena")
    public String formularioOlvideContrasena(){
        return "formularios/olvidecontrasena";}

    @GetMapping("/perfil")
    public String perfil(Model model
    ) {

        model.addAttribute("usuario", service);
        model.addAttribute("dataObject", menuServicio.findAll());
        return "rrhh/perfil";}


}
