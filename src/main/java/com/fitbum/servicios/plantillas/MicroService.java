package com.fitbum.servicios.plantillas;

import com.fitbum.entidades.plantillas.PlantillaMesociclo;
import com.fitbum.entidades.plantillas.PlantillaMicrociclo;
import com.fitbum.repositorios.plantillas.PlantMesoRepositorio;
import com.fitbum.repositorios.plantillas.PlantMicroRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MicroService {

    PlantMicroRepositorio ejerciciosRepositorio;
    protected MicroService(PlantMicroRepositorio ejerciciosRepositorio){
        this.ejerciciosRepositorio = ejerciciosRepositorio;}


    public List<PlantillaMicrociclo> findAll() {
        return ejerciciosRepositorio.findAll();
    }
    public Optional<PlantillaMicrociclo> findById(Integer id){
        return ejerciciosRepositorio.findById(id);
    }
}
