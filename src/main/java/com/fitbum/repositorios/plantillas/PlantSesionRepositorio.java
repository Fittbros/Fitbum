package com.fitbum.repositorios.plantillas;

import com.fitbum.entidades.plantillas.PlantillaMicrociclo;
import com.fitbum.entidades.plantillas.PlantillaSesion;
import com.fitbum.entidades.programa.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantSesionRepositorio extends JpaRepository<PlantillaSesion,Integer> {


    List<PlantillaSesion> findByPlantillaMicrociclo(PlantillaMicrociclo plantMicro);
}
