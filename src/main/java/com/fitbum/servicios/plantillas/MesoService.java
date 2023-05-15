package com.fitbum.servicios.plantillas;

import com.fitbum.entidades.plantillas.PlantillaMesociclo;
import com.fitbum.entidades.tutoriales.Ejercicios;
import com.fitbum.repositorios.plantillas.PlantMesoRepositorio;
import com.fitbum.repositorios.programa.EjerciciosRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MesoService {

    PlantMesoRepositorio plantMesoRepositorio;
    protected MesoService(PlantMesoRepositorio plantMesoRepositorio){
        this.plantMesoRepositorio = plantMesoRepositorio;}


    public List<PlantillaMesociclo> findAll() {
        return plantMesoRepositorio.findAll();
    }
    public Optional<PlantillaMesociclo> findById(Integer id){
        return plantMesoRepositorio.findById(id);
    }

    public PlantMesoRepositorio getPlantMesoRepositorio() {
        return plantMesoRepositorio;
    }
}
