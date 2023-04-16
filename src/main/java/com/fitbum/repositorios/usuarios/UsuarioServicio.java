package com.fitbum.repositorios.usuarios;

import com.fitbum.entidades.usuarios.DetalleUsuario;
import com.fitbum.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<DetalleUsuario> getAll(){
        return usuarioRepositorio.findAll();
    }
}
