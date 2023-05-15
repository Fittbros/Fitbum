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

    PlantSesionRepositorio plantSesionRepositorio;
    protected SesionService(PlantSesionRepositorio ejerciciosRepositorio){
        this.plantSesionRepositorio = ejerciciosRepositorio;}


    public List<PlantillaSesion> findAll() {
        return plantSesionRepositorio.findAll();
    }
    public Optional<PlantillaSesion> findById(Integer id){
        return plantSesionRepositorio.findById(id);
    }

    public PlantSesionRepositorio getPlantSesionRepositorio() {
        return plantSesionRepositorio;
    }
}
