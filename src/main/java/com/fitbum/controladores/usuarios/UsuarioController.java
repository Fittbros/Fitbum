package com.fitbum.controladores.usuarios;


import com.fitbum.controladores.AbstractController;
import com.fitbum.dto.LoginDto;
import com.fitbum.dto.RoleDTO;
import com.fitbum.dto.UsuarioDtoPsw;
import com.fitbum.dto.UsuarioDto;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.servicios.MenuServicio;
import com.fitbum.servicios.usuarios.IUsuarioServicio;
import com.fitbum.servicios.usuarios.RoleService;
import com.fitbum.servicios.usuarios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.fitbum.util.ValidarFormatoPassword.ValidarFormato;
//import org.springframework.validation.BindingResult;


@Controller
@Log4j2


public class UsuarioController extends AbstractController<Usuario> {

    @Autowired
    private UsuarioServicio service;

    @Autowired
    private RoleService roleService;

    @Autowired
    private IUsuarioServicio userService;




    protected UsuarioController(MenuServicio menuService) {
        super(menuService);
    }

    @GetMapping("/usuarios")
    @ResponseBody
    public List<Usuario> listar(){
        return service.listartodos();
    }

    //Para crear un usuario hay dos bloques
    //El que genera la pantalla para pedir los datos de tipo GetMapping
    //Cuando pasamos informacion a la pantalla hay que usar ModelMap
    @GetMapping("/usuarios/registro")
    public String vistaRegistro(Model interfazConPantalla) {
        //Instancia en memoria del dto a informar en la pantalla
        final UsuarioDto usuarioDto = new UsuarioDto();
        //Obtengo la lista de roles
        final List<RoleDTO> roleDTOList = roleService.buscarTodos();
        return "formularios/nuevoUsuario";
    }
        //Mediante "addAttribute" comparto con la pantalla




    //El que con los datos de la pantalla guarda la informacion de tipo PostMapping
    @PostMapping("/usuarios/registro")
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
            //El usuario se guarda como no autorizado
            //Guardo la password
            UsuarioDto usuario1 = this.service.guardar(usuarioDtoPsw);
            //return "usuarios/detallesusuario";
            return String.format("redirect:/usuarios/%s", usuario1.getId());
        }
        else
        {
            return "formularios/nuevoUsuario";
        }

    }
    @GetMapping("/registrar")
    public String crearUsuario(Usuario usuario){
        service.crearUsuario(usuario);
        return "/formularios/registrar";
    }
    @GetMapping("/registrar2")
    public String vistaReg(){
        return "/formularios/registrar";
    }
    @PostMapping("/registrar2")
    public String registrar(@ModelAttribute(name = "datosUsuario" ) Usuario loginDto) {
        String usr = loginDto.getUsername();
        System.out.println("usr :" + usr);
        String password = loginDto.getPassword();
        System.out.println("pass :" + password);
        //¿es correcta la password?
//        if (service.getUsuarioRepositorio().repValidarPassword(usr, passwordEncoder.encode(password) ) > 0)
//        {
            return "home";
//        }else {
//            return "formularios/registrar";
//        }
    }
//    @GetMapping("/registrar2")
//
//    public String registro(Model model){
//        model.addAttribute("datosUsuario", new Usuario() usuario);
//        service.crearUsuario(usuario);
//        return "/formularios/registrar";}


    @GetMapping("/usuarios/olvidecontrasena")
    public String formularioOlvideContrasena(){
        return "formularios/olvidecontrasena";}

    @GetMapping("/perfil")
    public String perfil(){
        return "rrhh/perfil";}


}
