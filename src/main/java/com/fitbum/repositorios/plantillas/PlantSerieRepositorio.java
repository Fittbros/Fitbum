package com.fitbum.repositorios.plantillas;

import com.fitbum.entidades.plantillas.PlantillaEjercicioFormulado;
import com.fitbum.entidades.plantillas.PlantillaSerie;
import com.fitbum.entidades.programa.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantSerieRepositorio extends JpaRepository<PlantillaSerie,Integer> {

    List<PlantillaSerie> findByPlantillaEjercicioFormulado(PlantillaEjercicioFormulado plantEjer);
}
