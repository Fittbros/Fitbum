package com.fitbum.repositorios.usuarios;

import com.fitbum.entidades.usuarios.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepositorio extends JpaRepository <Role,Long>{
}
