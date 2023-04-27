package com.fitbum.repositorios.usuarios;

import com.fitbum.entidades.usuarios.Suscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuscripcionRepositorio extends JpaRepository<Suscripcion, Long> {
}
