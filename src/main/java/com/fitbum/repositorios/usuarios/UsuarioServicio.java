package com.fitbum.repositorios.usuarios;

import com.fitbum.entidades.usuarios.DetalleUsuario;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.repositorios.DetallesRepositorio;
import com.fitbum.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    private DetallesRepositorio detallesRepositorio;

    public List<DetalleUsuario> getAll(){return detallesRepositorio.findAll();}



}
