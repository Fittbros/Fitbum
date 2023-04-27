package com.fitbum.repositorios.usuarios;
import com.fitbum.entidades.usuarios.DetalleUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface DetallesRepositorio extends JpaRepository<DetalleUsuario,Integer> {
    List<DetalleUsuario> findByNombre(@Param("nombre") String nombre);
    List<DetalleUsuario> findByApellido1(@Param("apellido1") String apellido1);

    DetalleUsuario findByEmailAndPassword(@Param("email") String email, @Param("password") String password);



}
