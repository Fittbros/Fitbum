package com.fitbum.repositorios.programa;

import com.fitbum.entidades.programa.Microciclo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicrocicloRepositorio extends JpaRepository<Microciclo,Integer> {
}
