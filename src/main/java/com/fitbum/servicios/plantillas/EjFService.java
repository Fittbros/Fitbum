package com.fitbum.servicios.plantillas;

import com.fitbum.entidades.plantillas.PlantillaEjercicioFormulado;
import com.fitbum.entidades.plantillas.PlantillaSerie;
import com.fitbum.repositorios.plantillas.PlantEjerFormRepositorio;
import com.fitbum.repositorios.plantillas.PlantMicroRepositorio;
import com.fitbum.repositorios.plantillas.PlantSerieRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EjFService {

    PlantEjerFormRepositorio ejerciciosRepositorio;
    protected EjFService(PlantEjerFormRepositorio ejerciciosRepositorio){
        this.ejerciciosRepositorio = ejerciciosRepositorio;}


    public List<PlantillaEjercicioFormulado> findAll() {
        return ejerciciosRepositorio.findAll();
    }
    public Optional<PlantillaEjercicioFormulado> findById(Integer id){
        return ejerciciosRepositorio.findById(id);
    }
}
