package com.fitbum.repositorios.programa;

import com.fitbum.entidades.Menu;
import com.fitbum.entidades.tutoriales.Ejercicios;
import com.fitbum.entidades.usuarios.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface EjerciciosRepositorio extends  JpaRepository<Ejercicios, Long> {
//    List<Ejercicios> findDistinctByGrupo_muscular(Collection<EjerciciosRepositorio> ej);

List<Ejercicios> findAllById(Integer id);
//Set<Ejercicios> findAllByGrupo_muscular(String grupo_muscular);
//public Optional<Ejercicios> findById(Integer id);

//    public Ejercicios findById(Integer id);
}
