package com.fitbum.repositorios.usuarios;

import com.fitbum.entidades.usuarios.Suscripcion;
import com.fitbum.entidades.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuscripcionRepositorio extends JpaRepository<Suscripcion, Integer> {

    List<Usuario> findAllByUsuario(Usuario usuario);
}
