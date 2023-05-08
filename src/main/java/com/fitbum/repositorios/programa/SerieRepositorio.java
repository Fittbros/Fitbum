package com.fitbum.repositorios.programa;

import com.fitbum.entidades.programa.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieRepositorio extends JpaRepository<Serie,Integer> {
}
