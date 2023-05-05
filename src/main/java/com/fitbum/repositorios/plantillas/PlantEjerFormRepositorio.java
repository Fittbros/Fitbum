package com.fitbum.repositorios.plantillas;

import com.fitbum.entidades.plantillas.PlantillaEjercicioFormulado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantEjerFormRepositorio  extends JpaRepository<PlantillaEjercicioFormulado,Long> {
}
