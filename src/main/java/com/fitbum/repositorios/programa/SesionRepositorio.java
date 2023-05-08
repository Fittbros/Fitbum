package com.fitbum.repositorios.programa;

import com.fitbum.entidades.programa.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SesionRepositorio extends JpaRepository<Sesion,Integer> {
}
