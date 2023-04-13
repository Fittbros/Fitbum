package com.fitbum.repositorios;

import com.fitbum.entidades.usuarios.DetalleUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<DetalleUsuario,Integer> {
}
