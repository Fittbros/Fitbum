package com.fitbum.controladores.websockets;

import com.fitbum.entidades.websockets.Notificacion;
import com.fitbum.repositorios.NotificacionRepositorio;
import com.fitbum.servicios.MenuServicio;
import com.fitbum.servicios.usuarios.UsuarioServicio;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
@Controller
public class NotificacionController {

    @Autowired
    private MenuServicio menuServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    NotificacionRepositorio notificacionRepositorio;

    @GetMapping("/numeroNotificaciones")
    @ResponseBody
//    @PreAuthorize("isAuthenticated()")
    public String contarNotificacionesPendientes(Principal principal) {
        List<Notificacion> listaNotificaciones =
                notificacionRepositorio.findByUserToAndEstado(
                        principal.getName(),
                        "Pendiente"
                );
        return String.valueOf(listaNotificaciones.size());
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/notificaciones")
    public String mostrarNotificaciones(Principal principal, Model model,
                                        @RequestParam("page") Optional<Integer> page,
                                        @RequestParam("size") Optional<Integer> size,
                                        @RequestParam("queryFrom") Optional<String> queryFrom,
                                        @RequestParam("queryTo") Optional<String> queryTo
    )
    {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        String searchFrom = queryFrom.orElse("");
        String searchTo = queryTo.orElse("");
        Page<Notificacion> pagina =
                notificacionRepositorio.findByUserFromContainingIgnoreCaseAndUserToContainingIgnoreCaseOrderByFechaDesc(

                        searchFrom,
                        searchTo,
                        PageRequest.of(currentPage - 1, pageSize)
                );
        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        model.addAttribute("queryFrom", searchFrom);
        model.addAttribute("queryTo", searchTo);
        model.addAttribute("pagina", pagina);
        int totalPages = pagina.getTotalPages();

        //Este código se puede sustituir por el de abajo comentado. Hacen lo mismo
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "/notificaciones/index";
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
        return "/notificaciones/index";
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
