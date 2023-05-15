package com.fitbum.repositorios.plantillas;

import com.fitbum.entidades.plantillas.PlantillaMesociclo;
import com.fitbum.entidades.programa.Mesociclo;
import com.fitbum.entidades.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PlantMesoRepositorio extends JpaRepository<PlantillaMesociclo,Integer> {

    List<PlantillaMesociclo> findAllByOrderByOrdenDesc();
//    List<PlantillaMesociclo> findByUsuario(Usuario usuario);
}
