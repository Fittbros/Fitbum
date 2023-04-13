package com.fitbum.Fitbum.rrhh.repositories;

import com.fitbum.Fitbum.entidades.DetalleUsuario;
import com.fitbum.Fitbum.rrhh.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<DetalleUsuario,Integer> {
}
