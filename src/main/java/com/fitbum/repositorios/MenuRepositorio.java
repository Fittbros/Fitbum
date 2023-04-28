package com.fitbum.repositorios;

import com.fitbum.entidades.Menu;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository

public interface MenuRepositorio extends JpaRepository<Menu,Integer> {



}

