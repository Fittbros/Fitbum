package com.fitbum.servicios.plantillas;

import com.fitbum.entidades.plantillas.PlantillaMicrociclo;
import com.fitbum.repositorios.plantillas.PlantMicroRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MicroService {

    PlantMicroRepositorio plantMicroRepositorio;
    protected MicroService(PlantMicroRepositorio ejerciciosRepositorio){
        this.plantMicroRepositorio = ejerciciosRepositorio;}


    public List<PlantillaMicrociclo> findAll() {
        return plantMicroRepositorio.findAll();
    }
    public Optional<PlantillaMicrociclo> findById(Integer id){
        return plantMicroRepositorio.findById(id);
    }

    public PlantMicroRepositorio getPlantMicroRepositorio() {
        return plantMicroRepositorio;
    }
}
