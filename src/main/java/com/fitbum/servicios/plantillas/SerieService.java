package com.fitbum.servicios.plantillas;

import com.fitbum.entidades.plantillas.PlantillaSerie;
import com.fitbum.entidades.plantillas.PlantillaSesion;
import com.fitbum.repositorios.plantillas.PlantMicroRepositorio;
import com.fitbum.repositorios.plantillas.PlantSerieRepositorio;
import com.fitbum.repositorios.plantillas.PlantSesionRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class SerieService {

    PlantSerieRepositorio ejerciciosRepositorio;
    protected SerieService(PlantSerieRepositorio ejerciciosRepositorio){
        this.ejerciciosRepositorio = ejerciciosRepositorio;}


    public List<PlantillaSerie> findAll() {
        return ejerciciosRepositorio.findAll();
    }
    public Optional<PlantillaSerie> findById(Integer id){
        return ejerciciosRepositorio.findById(id);
    }

    public PlantSerieRepositorio getEjerciciosRepositorio() {
        return ejerciciosRepositorio;
    }
}
