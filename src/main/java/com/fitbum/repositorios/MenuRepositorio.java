package com.fitbum.repositorios;

import com.fitbum.entidades.Menu;

import com.fitbum.entidades.usuarios.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


@Repository

public interface MenuRepositorio extends JpaRepository<Menu,Integer> {

    List<Menu> findDistinctByRolesIn(Collection<Role> roles);

    List<Menu> findDistinctByRolesInAndActivoTrue(Collection<Role> roles);



}

