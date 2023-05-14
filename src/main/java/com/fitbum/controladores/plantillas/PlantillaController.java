


package com.fitbum.controladores.plantillas;

import com.fitbum.entidades.plantillas.PlantillaMesociclo;
import com.fitbum.entidades.plantillas.PlantillaMicrociclo;
import com.fitbum.entidades.plantillas.PlantillaSesion;
import com.fitbum.entidades.programa.Mesociclo;
import com.fitbum.repositorios.plantillas.PlantMesoRepositorio;
import com.fitbum.servicios.MenuServicio;
import com.fitbum.servicios.plantillas.*;
import com.fitbum.servicios.usuarios.UsuarioServicio;
import jakarta.persistence.Column;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/plantillas")
public class PlantillaController {
    @Autowired
    private MenuServicio menuServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private PlantMesoRepositorio plantMesoRepositorio;
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
    @GetMapping(value = {"/",""})
    public String showMenu(
            Model model
    ) {

        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);


//        model.addAttribute("fragmentName", "fragment-customer-list");

        return "/plantillas/index";
    }
    //Bloque con controladores para mostrar datos por niveles
    @GetMapping(value = {"/meso"})
    public String plantMeso(
            Model model
    ) {
        PlantillaMesociclo plantillaMesociclo = new PlantillaMesociclo();
        //plantillaMesociclo.getPlantillaMicrociclo().iterator().next().getPlantillaSesion().iterator().next().getPlantillaEjercicioFormulado().iterator().next().getPlantillaSerie().iterator().next().;
        model.addAttribute("meso", plantMesoRepositorio.findAll());

        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        return "/plantillas/mesociclo";
    }
    @GetMapping(value = {"/micro"})
    public String plantMicro( Model model ) {
        model.addAttribute("micro", microService.findAll());

        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        return "/plantillas/microciclo";
    }
    @GetMapping(value = {"/sesion"})
    public String plantsesion(
            Model model
    ) {
        model.addAttribute("sesion", sesionService.findAll());
        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        return "/plantillas/sesion";
    }
    @GetMapping(value = {"/serie"})
    public String plantserie(
            Model model
    ) {
        model.addAttribute("serie", serieService.findAll());

        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        return "/plantillas/serie";
    }
    @GetMapping(value = {"/ejercicio"})
    public String plantejercicio(
            Model model
    ) {
        model.addAttribute("ej", ejFService.findAll());

        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        return "/plantillas/ejercicio";
    }
    //Controladores de edición
    @GetMapping("/meso/{id}")
    public String showMesoId(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        model.addAttribute("id", id);

        Optional<PlantillaMesociclo> meso= mesoService.findById(id);
        if(meso.isPresent()){
            model.addAttribute("meso", meso);
        }
        else{
            return "error";
        }

        return "/plantillas/mesoId";

    }
    @PostMapping("/meso/{id}")
    public String guardarMesoId(@PathVariable("id") Integer id, PlantillaMesociclo mesoentrada) {
        System.out.println( "@PostMapping:" + id + ":" + mesoentrada.getId() );
        Optional<PlantillaMesociclo> mesociclocontrol = mesoService.findById(mesoentrada.getId());
        System.out.println( "@PostMapping:" + id + ":" + mesoentrada.getId() );
        //¿Debería comprobar si hay datos?
        if (mesociclocontrol.isPresent()){
            System.out.println( "@PostMapping: isPresent" );
            PlantillaMesociclo mesociclo = mesociclocontrol.get();
            mesociclo.setNumMicrociclos(mesoentrada.getNumMicrociclos());
            mesociclo.setFrEntreSemana(mesoentrada.getFrEntreSemana());
            mesociclo.setLongMicrociclo(mesoentrada.getLongMicrociclo());
            mesociclo.setDescansoBas(mesoentrada.getDescansoBas());
            mesociclo.setDescansoAcces(mesoentrada.getDescansoAcces());
            mesociclo.setDescripcion(mesoentrada.getDescripcion());
            this.mesoService.getPlantMesoRepositorio().save(mesociclo);
            return String.format("redirect:/plantillas/meso/%s", mesociclo.getId());
        }
        else{
            return "error";
        }
    }
    @GetMapping(value = {"/micro/{id}"})
    public String showMicroId(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        model.addAttribute("id", id);

        Optional<PlantillaMicrociclo> micro= microService.findById(id);
        if(micro.isPresent()){
            model.addAttribute("micro", micro);
        }
        else{
            return "error";
        }

        return "plantillas/microId";
    }
    @PostMapping(value = {"/micro/{id}"})
    public String guardarMicroId(@PathVariable("id") Integer id, PlantillaMicrociclo microcicloentrada) {
        Optional<PlantillaMicrociclo> microciclocontrol = microService.findById(id);
        //¿Debería comprobar si hay datos?
        if (microciclocontrol.isPresent()){
            PlantillaMicrociclo microciclo = microciclocontrol.get();
            microciclo.setIntensidadEstandar(microcicloentrada.getIntensidadEstandar());
            microciclo.setVolumenEstandar(microcicloentrada.getVolumenEstandar());

            this.microService.getPlantMicroRepositorio().save(microciclo);
            return String.format("redirect:/plantillas/micro/%s", id);
        }
        else{
            return "error";
        }
    }
    @GetMapping(value = {"/sesion/{id}"})
    public String showSesionId(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        model.addAttribute("id", id);

        Optional<PlantillaSesion> sesion= sesionService.findById(id);
        if(sesion.isPresent()){
            model.addAttribute("sesion", sesion);
        }
        else{
            return "error";
        }

        return "plantillas/sesionId";
    }
    @PostMapping(value = {"/sesion/{id}"})
    public String guardarSesionId(@PathVariable("id") Integer id, PlantillaSesion plantillaSesionentrada) {
        Optional<PlantillaSesion> plantillaSesioncontrol = sesionService.findById(id);
        //¿Debería comprobar si hay datos?
        if (plantillaSesioncontrol.isPresent()){
            PlantillaSesion sesion = plantillaSesioncontrol.get();
            sesion.setDescripcion(plantillaSesionentrada.getDescripcion());

            this.sesionService.getPlantSesionRepositorio().save(sesion);
            return String.format("redirect:/plantillas/sesion/%s", id);
        }
        else{
            return "error";
        }
    }

}
