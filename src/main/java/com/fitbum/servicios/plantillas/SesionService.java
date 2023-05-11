package com.fitbum.servicios.plantillas;

import com.fitbum.entidades.plantillas.PlantillaMicrociclo;
import com.fitbum.entidades.plantillas.PlantillaSesion;
import com.fitbum.repositorios.plantillas.PlantMicroRepositorio;
import com.fitbum.repositorios.plantillas.PlantSesionRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class SesionService {

    PlantSesionRepositorio ejerciciosRepositorio;
    protected SesionService(PlantSesionRepositorio ejerciciosRepositorio){
        this.ejerciciosRepositorio = ejerciciosRepositorio;}


    public List<PlantillaSesion> findAll() {
        return ejerciciosRepositorio.findAll();
    }
    public Optional<PlantillaSesion> findById(Integer id){
        return ejerciciosRepositorio.findById(id);
    }
}
