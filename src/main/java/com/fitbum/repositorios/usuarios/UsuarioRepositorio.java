package com.fitbum.repositorios.usuarios;

import com.fitbum.entidades.usuarios.DetalleUsuario;
import com.fitbum.entidades.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {

}
