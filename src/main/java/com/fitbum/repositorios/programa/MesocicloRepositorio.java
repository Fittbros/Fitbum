package com.fitbum.repositorios.programa;

import com.fitbum.entidades.programa.Mesociclo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MesocicloRepositorio  extends JpaRepository<Mesociclo,Integer> {
    List<Mesociclo> findAllByOrderByOrdenDesc();
}
