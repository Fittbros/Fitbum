package com.fitbum.repositorios.plantillas;

import com.fitbum.entidades.plantillas.PlantillaEjercicioFormulado;
import com.fitbum.entidades.plantillas.PlantillaSesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantEjerFormRepositorio  extends JpaRepository<PlantillaEjercicioFormulado,Integer> {

    List<PlantillaEjercicioFormulado> findByPlantillaSesion(PlantillaSesion platSesion);
    List<PlantillaEjercicioFormulado> findByIdEjercicio(Integer id);

}
