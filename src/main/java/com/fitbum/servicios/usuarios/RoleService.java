package com.fitbum.servicios.usuarios;


import com.fitbum.dto.RoleDTO;
import com.fitbum.entidades.usuarios.Role;
import com.fitbum.repositorios.usuarios.RoleRepositorio;
import com.fitbum.repositorios.usuarios.UsuarioRepositorio;
import com.fitbum.servicios.AbstractBusinessService;
import com.fitbum.servicios.mapper.RoleServiceMapper;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends AbstractBusinessService<Role, Integer, RoleDTO, RoleRepositorio, RoleServiceMapper> {

    private final UsuarioRepositorio usuarioRepository;

    protected RoleService(RoleRepositorio repository, RoleServiceMapper serviceMapper, UsuarioRepositorio usuarioRepository) {
        super(repository, serviceMapper);
        this.usuarioRepository = usuarioRepository;
    }

}
