package com.fitbum.repositorios;


import com.fitbum.entidades.websockets.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface NotificacionRepositorio extends JpaRepository<Notificacion, String> {

    public List<Notificacion> findByUserToAndEstado(String userTo, String estado);

}

