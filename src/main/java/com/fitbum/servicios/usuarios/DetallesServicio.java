package com.fitbum.servicios.usuarios;

import com.fitbum.entidades.usuarios.DetalleUsuario;
import com.fitbum.entidades.usuarios.Rol;
import com.fitbum.entidades.usuarios.Suscripcion;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.repositorios.DetallesRepositorio;
import com.fitbum.repositorios.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Service
public class DetallesServicio {
    @Autowired
    private DetallesRepositorio detallesRepositorio;
    @Autowired
    private RolRepositorio rolRepositorio;

    public boolean comprobarUsuario(String email, String password) {
        DetalleUsuario detalleUsuario = detallesRepositorio.findByEmailAndPassword(email, password);
        if (detalleUsuario == null) {
            return false;
        } else {
            return true;
        }
    }
    public void crearUsuario(DetalleUsuario detalleUsuario){
        Usuario usuario = new Usuario();
        Optional<Rol> rol = rolRepositorio.findById(3L);
        Suscripcion suscripcion = new Suscripcion();
        usuario.setRol(rol.get());
        detalleUsuario.setUsuario(usuario);
        detallesRepositorio.save(detalleUsuario);
    }

}
