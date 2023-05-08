package com.fitbum.servicios.programas;

import com.fitbum.entidades.programa.Sesion;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.repositorios.programa.SesionRepositorio;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
public class SesionServicio {
    @Autowired
    private SesionRepositorio sesionRepositorio;
    public List<Sesion> listartodos(){
        List<Sesion> sesionList = sesionRepositorio.findAll();
        return sesionRepositorio.findAll();

    }
}
