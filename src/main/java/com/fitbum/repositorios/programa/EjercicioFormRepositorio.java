package com.fitbum.repositorios.programa;

import com.fitbum.entidades.programa.EjercicioForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjercicioFormRepositorio extends JpaRepository<EjercicioForm,Integer> {
}
