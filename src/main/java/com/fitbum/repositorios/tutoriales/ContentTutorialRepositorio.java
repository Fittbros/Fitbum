package com.fitbum.repositorios.tutoriales;

import com.fitbum.entidades.tutoriales.ContentTutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentTutorialRepositorio  extends JpaRepository<ContentTutorial,Integer> {
}
