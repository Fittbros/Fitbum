package com.fitbum.repositorios.usuarios;


import com.fitbum.entidades.usuarios.DetalleUsuario;
import com.fitbum.entidades.usuarios.Role;
import com.fitbum.entidades.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {



    Usuario findById(@Param("IdUsuario") Integer idUsuario);
    Usuario findByRole(@Param("Role") Integer idRole);
//    List<Usuario> findByRoleList(@Param("IdRole") Role idRole);

}
