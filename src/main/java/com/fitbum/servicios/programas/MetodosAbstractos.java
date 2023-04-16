package com.fitbum.servicios.programas;

import java.util.List;

public abstract class MetodosAbstractos<T> {

    // Método para crear un nuevo registro en la base de datos
    public abstract void create(T entity);

    // Método para buscar un registro en la base de datos a partir de su ID
    public abstract T findById(Long id);

    // Método para actualizar un registro en la base de datos
    public abstract void update(T entity);

    // Método para eliminar un registro de la base de datos a partir de su ID
    public abstract void deleteById(Long id);

    // Método para obtener todos los registros de una entidad de la base de datos
    public abstract List<T> findAll();
}


