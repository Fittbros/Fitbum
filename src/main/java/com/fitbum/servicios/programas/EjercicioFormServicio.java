package com.fitbum.servicios.programas;

import com.fitbum.entidades.programa.EjercicioForm;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.repositorios.programa.EjercicioFormRepositorio;
import com.fitbum.repositorios.tutoriales.EjercicioRepositorio;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
public class EjercicioFormServicio {
    @Autowired
    private EjercicioFormRepositorio ejercicioFormRepositorio;

    public List<EjercicioForm> listartodos(){
        List<EjercicioForm> ejercicicioList = ejercicioFormRepositorio.findAll();
        return ejercicioFormRepositorio.findAll();

    }
}
