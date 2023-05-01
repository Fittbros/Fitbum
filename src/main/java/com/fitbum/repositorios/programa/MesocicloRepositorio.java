package com.fitbum.repositorios.programa;

import com.fitbum.entidades.programa.Mesociclo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesocicloRepositorio  extends JpaRepository<Mesociclo,Long> {
}
