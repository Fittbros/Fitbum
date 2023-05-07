package com.fitbum.repositorios.usuarios;


import com.fitbum.entidades.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {

    @Query("Select count(id) from Usuario where username= ?1 and password = ?2")
    Integer repValidarPassword(String username, String password);

    Usuario findByid(@Param("id") Integer id);
    Usuario findByRole(@Param("Role") Integer id);

    Usuario findUsuarioByEmail(String email);
    Usuario findUsuarioByUsername(String username);

    Usuario findUsuarioByEmailAndActiveTrue(String email);
    Usuario findUsuarioByUsernameAndActiveTrue(String username);


}
