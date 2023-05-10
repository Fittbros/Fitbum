package com.fitbum.servicios.tutoriales;

import com.fitbum.entidades.tutoriales.Ejercicios;
import com.fitbum.repositorios.programa.EjerciciosRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EjerciciosServicio {

    EjerciciosRepositorio ejerciciosRepositorio;


    public List<Ejercicios> findAll() {
        return ejerciciosRepositorio.findAll();
    }
    public Optional<Ejercicios> findById(Integer id){
        return ejerciciosRepositorio.findById(Long.valueOf(id));
    }
}
