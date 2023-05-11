package com.fitbum.controladores.websockets;

import com.fitbum.entidades.websockets.Notificacion;
import com.fitbum.repositorios.NotificacionRepositorio;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Log4j2
@Controller
public class NotificacionController {

    @Autowired
    NotificacionRepositorio notificacionRepositorio;

    @GetMapping("/numeroNotificaciones")
    @ResponseBody
    public String contarNotificacionesPendientes(Principal principal) {
        List<Notificacion> listaNotificaciones =
                notificacionRepositorio.findByUserToAndEstado(
                        principal.getName(),
                        "Pendiente"
                );
        return String.valueOf(listaNotificaciones.size());
    }


    @GetMapping("/notificaciones")
    public String mostrarNotificacionesPendientes(Principal principal, Model model) {
        List<Notificacion> listaNotificaciones =
                notificacionRepositorio.findByUserToAndEstado(
                        principal.getName(),
                        "Pendiente"
                );
        model.addAttribute("listaNotificaciones", listaNotificaciones);
        return "notificaciones/list";
    }


    @GetMapping("/leerNotificaciones")
    public String leerNotificacionesPendientes(Principal principal, Model model) {
        List<Notificacion> listaNotificaciones =
                notificacionRepositorio.findByUserToAndEstado(
                        principal.getName(),
                        "Pendiente"
                );
        listaNotificaciones.forEach(notificacion -> {
            notificacion.setEstado("READ");
            notificacionRepositorio.save(notificacion);
        });
        model.addAttribute("listaNotificaciones", listaNotificaciones);
        return "notificaciones/list";
    }


    @GetMapping("/leerNotificacion/{id}")
    public String leerNotificacionesPendientes(@PathVariable("id") String id, Principal principal, Model model) {
        Optional<Notificacion> notificacion = notificacionRepositorio.findById(id);

        if (notificacion.isPresent()) {
            log.info("ESTAMOS MARCANDO LA NOTIFICACION " + notificacion.get().getId());
            notificacion.get().setEstado("READ");
            notificacionRepositorio.save(notificacion.get());
        }

        return "redirect:/notificaciones";
    }


}
