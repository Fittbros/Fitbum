package com.fitbum.repositorios.plantillas;

import com.fitbum.entidades.plantillas.PlantillaMesociclo;
import com.fitbum.entidades.programa.Mesociclo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantMesoRepositorio extends JpaRepository<PlantillaMesociclo,Long> {
}
