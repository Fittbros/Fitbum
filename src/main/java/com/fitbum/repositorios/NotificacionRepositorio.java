package com.fitbum.repositorios;

import com.fitbum.entidades.Notificacion;
import com.fitbum.entidades.estadisticas.Estadisticas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface NotificacionRepositorio extends JpaRepository<Notificacion,Integer> {
}

