package com.fitbum.repositorios.programa;

import com.fitbum.entidades.Menu;
import com.fitbum.entidades.tutoriales.Ejercicios;
import com.fitbum.entidades.usuarios.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface EjerciciosRepositorio extends CrudRepository<Ejercicios, Integer>, JpaRepository<Ejercicios, Integer> {
    List<Ejercicios> findDistinctByGrupo_muscular(Collection<EjerciciosRepositorio> ej);



}
