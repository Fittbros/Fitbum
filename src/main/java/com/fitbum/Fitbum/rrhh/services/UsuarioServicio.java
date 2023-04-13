package com.fitbum.Fitbum.rrhh.services;

import com.fitbum.Fitbum.entidades.DetalleUsuario;
import com.fitbum.Fitbum.rrhh.models.Usuario;
import com.fitbum.Fitbum.rrhh.repositories.UsuarioRepositorio;
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
