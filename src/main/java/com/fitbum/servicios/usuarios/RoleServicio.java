package com.fitbum.servicios.usuarios;

import com.fitbum.dto.RoleDTO;
import com.fitbum.entidades.usuarios.Role;
import com.fitbum.repositorios.usuarios.RoleRepositorio;
import com.fitbum.repositorios.usuarios.UsuarioRepositorio;
import com.fitbum.servicios.ServiciosAbstractos;
import com.fitbum.servicios.mapper.RoleServicioMapper;

public class RoleServicio extends ServiciosAbstractos<Role, Integer, RoleDTO, RoleRepositorio, RoleServicioMapper> {

    private final UsuarioRepositorio usuarioRepositorio;

    protected RoleService(RoleRepositorio roleRepositorio, RoleServicioMapper roleServicioMapper, UsuarioRepositorio usuarioRepositorio) {
        super(repository, serviceMapper);
        this.usuarioRepository = usuarioRepository;
    }

    protected RoleServicio(RoleRepositorio roleRepositorio, RoleServicioMapper mapper) {
        super(roleRepositorio, mapper);
    }
}

