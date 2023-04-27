package com.fitbum.servicios.usuarios;

import com.fitbum.entidades.usuarios.DetalleUsuario;
import com.fitbum.repositorios.usuarios.DetallesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio {
    @Autowired
    private DetallesRepositorio detallesRepositorio;

    public List<DetalleUsuario> getAll(){return detallesRepositorio.findAll();}



}
