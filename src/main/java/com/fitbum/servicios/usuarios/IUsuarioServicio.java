package com.fitbum.servicios.usuarios;


import com.fitbum.entidades.usuarios.Usuario;

public interface IUsuarioServicio {
    public String getEncodedPassword(Usuario usuario);
}
