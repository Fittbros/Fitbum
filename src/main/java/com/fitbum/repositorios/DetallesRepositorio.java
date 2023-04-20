package com.fitbum.repositorios;
import com.fitbum.entidades.usuarios.DetalleUsuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "usuario",path = "usuario")
public interface DetallesRepositorio extends CrudRepository <DetalleUsuario,Integer>{
    List<DetalleUsuario> findByNombre(@Param("nombre") String nombre);
    List<DetalleUsuario> findByApellido1(@Param("apellido1") String apellido1);
}