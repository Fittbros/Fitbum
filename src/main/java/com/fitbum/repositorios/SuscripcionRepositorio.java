package com.fitbum.repositorios;

import com.fitbum.entidades.usuarios.Suscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuscripcionRepositorio extends JpaRepository<Suscripcion, Long> {
}
