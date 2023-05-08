package com.fitbum.repositorios.plantillas;

import com.fitbum.entidades.plantillas.PlantillaSerie;
import com.fitbum.entidades.programa.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantSerieRepositorio extends JpaRepository<PlantillaSerie,Integer> {
}
