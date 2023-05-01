package com.fitbum.repositorios.usuarios;

import com.fitbum.entidades.usuarios.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepositorio extends JpaRepository<Role, Long>{

    Page<Role> findAll(Pageable pageable);
}
