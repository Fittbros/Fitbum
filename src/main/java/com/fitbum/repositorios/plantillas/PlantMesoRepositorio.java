package com.fitbum.repositorios.plantillas;

import com.fitbum.entidades.plantillas.PlantillaMesociclo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantMesoRepositorio extends JpaRepository<PlantillaMesociclo,Integer> {

    List<PlantillaMesociclo> findAllByOrderByOrdenDesc();
}
