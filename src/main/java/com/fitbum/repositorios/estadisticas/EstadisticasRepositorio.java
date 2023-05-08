package com.fitbum.repositorios.estadisticas;

import com.fitbum.entidades.estadisticas.Estadisticas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EstadisticasRepositorio extends JpaRepository<Estadisticas,Integer> {

    Page<Estadisticas> findAll(Pageable pageable);
}

