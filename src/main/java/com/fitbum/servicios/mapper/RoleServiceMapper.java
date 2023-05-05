package com.fitbum.servicios.mapper;



import com.fitbum.dto.RoleDTO;
import com.fitbum.entidades.usuarios.Role;
import com.fitbum.repositorios.usuarios.RoleRepositorio;
import com.fitbum.servicios.AbstractBusinessService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceMapper extends AbstractBusinessService<Role, Integer, RoleDTO, RoleRepositorio, RoleServiceMapper> {

    protected RoleServiceMapper(RoleRepositorio roleRepositorio, RoleServiceMapper mapper) {
        super(roleRepositorio, mapper);
    }

    public Role toEntity(RoleDTO dto) {
        final Role entidad = new Role();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return entidad;
    }

    public RoleDTO toDto(Role entidad) {
        final RoleDTO dto = new RoleDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }
}
