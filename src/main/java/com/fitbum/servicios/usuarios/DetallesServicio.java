package com.fitbum.servicios.usuarios;

import com.fitbum.entidades.usuarios.DetalleUsuario;
import com.fitbum.entidades.usuarios.Role;
import com.fitbum.entidades.usuarios.Suscripcion;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.repositorios.usuarios.DetallesRepositorio;
import com.fitbum.repositorios.usuarios.RoleRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetallesServicio {
    @Autowired
    private DetallesRepositorio detallesRepositorio;
    @Autowired
    private RoleRepositorio rolRepositorio;

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
        Optional<Role> rol = rolRepositorio.findById(3);
        Suscripcion suscripcion = new Suscripcion();
        usuario.setRole(rol.get());
        detalleUsuario.setUsuario(usuario);
        detallesRepositorio.save(detalleUsuario);
    }

}
