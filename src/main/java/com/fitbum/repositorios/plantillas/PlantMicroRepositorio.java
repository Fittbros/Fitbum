package com.fitbum.repositorios.plantillas;

import com.fitbum.entidades.plantillas.PlantillaMicrociclo;
import com.fitbum.entidades.programa.Microciclo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantMicroRepositorio extends JpaRepository<PlantillaMicrociclo,Integer> {
}
