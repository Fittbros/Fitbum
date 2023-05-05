package com.fitbum.repositorios.estadisticas;

import com.fitbum.entidades.estadisticas.Informes;
import com.fitbum.entidades.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface InformesRepositorio extends JpaRepository<Informes,Integer> {

    List<Usuario> findAllByUsuario(Usuario usuario);
}
