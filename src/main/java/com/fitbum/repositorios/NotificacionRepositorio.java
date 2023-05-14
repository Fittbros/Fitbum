package com.fitbum.repositorios;


import com.fitbum.entidades.websockets.Notificacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface NotificacionRepositorio extends JpaRepository<Notificacion, String> {

    public List<Notificacion> findByUserToAndEstado(String userTo, String estado);
    public Page<Notificacion> findByUserFromContainingIgnoreCaseAndUserToContainingIgnoreCaseOrderByFechaDesc(String userFrom, String userTo, Pageable pageable);
    public Page<Notificacion>  findByUserFromAndUserToLikeIgnoreCaseOrderByFechaDesc(String userFrom,String userTo, Pageable pageable);
    public Page<Notificacion> findByUserToOrderByFechaDesc(String userTo, Pageable pageable);
    public Page<Notificacion> findByUserToContainingIgnoreCaseOrderByFechaDesc (String userLike, Pageable pageable);


}

