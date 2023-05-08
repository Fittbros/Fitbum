package com.fitbum.repositorios.tutoriales;

import com.fitbum.entidades.tutoriales.Ejercicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjercicioRepositorio extends JpaRepository<Ejercicios,Integer> {
}
