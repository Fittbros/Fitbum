package com.fitbum.repositorios.estadisticas;

import com.fitbum.entidades.estadisticas.Informes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface InformesRepositorio extends JpaRepository<Informes,Integer> {

}
