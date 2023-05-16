


package com.fitbum.controladores.programa;

import com.fitbum.entidades.plantillas.PlantillaMesociclo;
import com.fitbum.entidades.plantillas.PlantillaMicrociclo;
import com.fitbum.entidades.plantillas.PlantillaSesion;
import com.fitbum.entidades.programa.Mesociclo;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.filemanagement.models.FileInfo;
import com.fitbum.repositorios.programa.MesocicloRepositorio;
import com.fitbum.servicios.MenuServicio;
import com.fitbum.servicios.plantillas.*;
import com.fitbum.servicios.programas.MesocicloServicio;
import com.fitbum.servicios.usuarios.UsuarioServicio;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@Log4j2
@RequestMapping("/programa")
public class ProgramaController {
    @Autowired
    private MenuServicio menuServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private MesocicloRepositorio mesocicloRepositorio;
    @Autowired
    private MesoService mesoService;
    @Autowired
    private MicroService microService;
    @Autowired
    private SesionService sesionService;
    @Autowired
    private SerieService serieService;
    @Autowired
    private EjFService ejFService;
    @Autowired
    private MesocicloServicio mesocicloServicio;

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

        return "/programa/index";
    }
    //Bloque con controladores para mostrar datos por niveles
    @GetMapping(value = {"/meso"})
    public String plantMeso(
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
        PlantillaMesociclo plantillaMesociclo=new PlantillaMesociclo();
        Mesociclo mesociclo = new Mesociclo(plantillaMesociclo);
        mesociclo=mesocicloRepositorio.save(mesociclo);
        //plantillaMesociclo.getPlantillaMicrociclo().iterator().next().getPlantillaSesion().iterator().next().getPlantillaEjercicioFormulado().iterator().next().getPlantillaSerie().iterator().next().;
        model.addAttribute("listaprogrameso", mesocicloRepositorio.findAllByOrderByOrdenDesc());
        model.addAttribute("usuario", usuarioServicio);
        return "/programa/mesociclo";
    }
    @GetMapping(value = {"/micro"})
    public String plantMicro( Model model, Authentication authentication
    ) {
        String username = authentication.getName();
        Optional<Usuario> usuario = Optional.ofNullable(usuarioServicio.getRepo().findUsuarioByUsername(username));
        if(usuario.isPresent()){
            model.addAttribute("logeduser",usuario.get());}
        else{
            return "error";
        }
        model.addAttribute("dataObject", menuServicio.getMenuForUsername(username));
        model.addAttribute("micro", microService.findAll());

        model.addAttribute("usuario", usuarioServicio);
        return "/programa/microciclo";
    }
    @GetMapping(value = {"/sesion"})
    public String plantsesion(
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
        model.addAttribute("sesion", sesionService.findAll());

        model.addAttribute("usuario", usuarioServicio);
        return "/programa/sesion";
    }
    @GetMapping(value = {"/serie"})
    public String plantserie(
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
        model.addAttribute("serie", serieService.findAll());

        model.addAttribute("usuario", usuarioServicio);
        return "/programa/serie";
    }
    @GetMapping(value = {"/ejercicio"})
    public String plantejercicio(
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
        model.addAttribute("ej", ejFService.findAll());

        model.addAttribute("usuario", usuarioServicio);
        return "/programa/ejercicio";
    }
    //Controladores de edición
    @GetMapping("/meso/{id}")
    public String showMesoId(@PathVariable("id") Integer id, Model model, Authentication authentication
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
        model.addAttribute("id", id);

        Optional<PlantillaMesociclo> meso= mesoService.findById(id);
        if(meso.isPresent()){
            model.addAttribute("meso", meso);
        }
        else{
            return "redirect:/error";
        }

        return "/programa/mesoId";

    }
    @PostMapping("/meso/{id}")
    public String guardarMesoId(@PathVariable("id") Integer id, PlantillaMesociclo mesoentrada) {

        Optional<PlantillaMesociclo> mesociclocontrol = mesoService.findById(mesoentrada.getId());
        //¿Debería comprobar si hay datos?
        if (mesociclocontrol.isPresent()){
            PlantillaMesociclo mesociclo = mesociclocontrol.get();
            mesociclo.setNumMicrociclos(mesoentrada.getNumMicrociclos());
            mesociclo.setFrEntreSemana(mesoentrada.getFrEntreSemana());
            mesociclo.setLongMicrociclo(mesoentrada.getLongMicrociclo());
            mesociclo.setDescansoBas(mesoentrada.getDescansoBas());
            mesociclo.setDescansoAcces(mesoentrada.getDescansoAcces());
            mesociclo.setDescripcion(mesoentrada.getDescripcion());
            this.mesoService.getPlantMesoRepositorio().save(mesociclo);
            return String.format("redirect:/programa/meso/%s", mesociclo.getId());
        }
        else{
            return "redirect:/error";
        }
    }
    @GetMapping(value = {"/micro/{id}"})
    public String showMicroId(@PathVariable("id") Integer id, ModelMap modelMap, Model model, Authentication authentication
    ) {
        String username = authentication.getName();
        Optional<Usuario> usuario = Optional.ofNullable(usuarioServicio.getRepo().findUsuarioByUsername(username));
        if(usuario.isPresent()){
            model.addAttribute("logeduser",usuario.get());}
        else{
            return "error";
        }
        model.addAttribute("dataObject", menuServicio.getMenuForUsername(username));
        modelMap.addAttribute("usuario", usuarioServicio);
        modelMap.addAttribute("id", id);

        Optional<PlantillaMicrociclo> micro= microService.findById(id);
        if(micro.isPresent()){
            modelMap.addAttribute("micro", micro);
        }
        else{
            return "redirect:/error";
        }

        return "programa/microId";
    }
    @PostMapping(value = {"/micro/{id}"})
    public String guardarMicroId(@PathVariable("id") Integer id, PlantillaMicrociclo microcicloentrada, Model model, Authentication authentication
    ) {
        String username = authentication.getName();
        Optional<Usuario> usuario = Optional.ofNullable(usuarioServicio.getRepo().findUsuarioByUsername(username));
        if(usuario.isPresent()){
            model.addAttribute("logeduser",usuario.get());}
        else{
            return "error";
        }
        model.addAttribute("dataObject", menuServicio.getMenuForUsername(username));
        Optional<PlantillaMicrociclo> microciclocontrol = microService.findById(microcicloentrada.getId());
        //¿Debería comprobar si hay datos?
        if (microciclocontrol.isPresent()){
            PlantillaMicrociclo microciclo = microciclocontrol.get();
            microciclo.setIntensidadEstandar(microcicloentrada.getIntensidadEstandar());
            microciclo.setVolumenEstandar(microcicloentrada.getVolumenEstandar());

            this.microService.getPlantMicroRepositorio().save(microciclo);
            return String.format("redirect:/programa/micro/%s", microciclo.getId());
        }
        else{
            return "error";
        }

    }
    @GetMapping(value = {"/sesion/{id}"})
    public String showSesionId(@PathVariable("id") Integer id, ModelMap modelMap, Model model, Authentication authentication
    ) {
        String username = authentication.getName();
        Optional<Usuario> usuario = Optional.ofNullable(usuarioServicio.getRepo().findUsuarioByUsername(username));
        if(usuario.isPresent()){
            model.addAttribute("logeduser",usuario.get());}
        else{
            return "error";
        }
        model.addAttribute("dataObject", menuServicio.getMenuForUsername(username));
        modelMap.addAttribute("usuario", usuarioServicio);
        modelMap.addAttribute("id", id);

        Optional<PlantillaSesion> sesion= sesionService.findById(id);
        if(sesion.isPresent()){
            modelMap.addAttribute("sesion", sesion);
        }
        else{
            return "error";
        }

        return "programa/sesionId";
    }
    @PostMapping(value = {"/sesion/{id}"})
    public String guardarSesionId(@PathVariable("id") Integer id, PlantillaSesion sesionentrada) {
        Optional<PlantillaSesion> sesioncontrol = sesionService.findById(sesionentrada.getId());
        //¿Debería comprobar si hay datos?
        if (sesioncontrol.isPresent()){
            PlantillaSesion sesion = sesioncontrol.get();
            sesion.setVariante(sesionentrada.getVariante());
            sesion.setNum_sesion(sesionentrada.getNum_sesion());

            this.sesionService.getPlantSesionRepositorio().save(sesion);
            return String.format("redirect:/programa/sesion/%s", sesion.getId());
        }
        else{
            return "error";
        }
    }
    @GetMapping(value = {"/crearrutina/{id}"})
    public String showCrearRutina(@PathVariable("id") Integer id,
                                             ModelMap modelMap,
                                             Model model, Authentication authentication){
        String username = authentication.getName();
        Optional<Usuario> usuario = Optional.ofNullable(usuarioServicio.getRepo().findUsuarioByUsername(username));
        if(usuario.isPresent()){
            model.addAttribute("logeduser",usuario.get());}
        else{
            return "error";
        }
        model.addAttribute("dataObject", menuServicio.getMenuForUsername(username));
        modelMap.addAttribute("usuario", usuarioServicio);
        modelMap.addAttribute("id", id);

        List<PlantillaMesociclo> pmesos = mesoService.findAll();
//        Optional<Mesociclo> meso = mesocicloServicio.findById(id);
        Mesociclo meso=new Mesociclo();
        model.addAttribute("pmesos", pmesos);
        model.addAttribute("meso", meso);
//        new Mesociclo(pmesos)=

        return "programa/crearRutina";
    }

    @PostMapping("/crearRutina")
    public String crearnuevo(Mesociclo mesociclo, Model model) {
    model.addAttribute("dataObject", menuServicio.findAll());
    model.addAttribute("usuario", usuarioServicio);

    mesocicloServicio.getRepo().save(mesociclo);
        return String.format("redirect:/programa/crearrutina%s", mesociclo.getId());


    }





}
