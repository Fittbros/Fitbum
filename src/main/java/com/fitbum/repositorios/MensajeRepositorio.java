package com.fitbum.repositorios;

import com.fitbum.entidades.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MensajeRepositorio extends JpaRepository<Mensaje,Integer> {
}

