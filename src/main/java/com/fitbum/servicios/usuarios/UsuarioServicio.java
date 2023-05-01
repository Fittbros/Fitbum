package com.fitbum.servicios.usuarios;

import com.fitbum.dto.UsuarioDto;
import com.fitbum.entidades.usuarios.DetalleUsuario;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.repositorios.usuarios.DetallesRepositorio;
import com.fitbum.repositorios.usuarios.UsuarioRepositorio;
import com.fitbum.servicios.ServiciosAbstractos;
import com.fitbum.servicios.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio extends ServiciosAbstractos<Usuario,Long, UsuarioDto, UsuarioRepositorio, UsuarioMapper> {
    @Autowired
    private DetallesRepositorio detallesRepositorio;

    public List<DetalleUsuario> getAll(){return detallesRepositorio.findAll();}



}
