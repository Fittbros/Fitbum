package com.fitbum.Fitbum.rrhh.services;

import com.fitbum.Fitbum.rrhh.models.Usuario;
import com.fitbum.Fitbum.rrhh.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

}
