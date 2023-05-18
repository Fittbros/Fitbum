package com.fitbum.repositorios.plantillas;


import com.fitbum.entidades.plantillas.PlantillaMesociclo;
import com.fitbum.entidades.plantillas.PlantillaMicrociclo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantMicroRepositorio extends JpaRepository<PlantillaMicrociclo,Integer> {

    List<PlantillaMicrociclo> findByPlantillaMesociclo(PlantillaMesociclo plantMeso);
}
