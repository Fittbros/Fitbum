package com.fitbum.repositorios.usuarios;

import com.fitbum.entidades.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {

    @Query("Select count(id) from Usuario where email= ?1 and password = ?2")
    Integer repValidarPassword(String email, String password);

    Usuario findUsuarioByNombreUsuarioIs(String name);
    Usuario findByEmailAndActiveTrue(String name);

    Usuario findByNombreUsuarioAndActiveTrue(String name);


    Usuario findUsuarioByEmailAndActiveTrue(String email);
    Usuario findUsuarioByEmailAndPassword(String email, String password);

}
