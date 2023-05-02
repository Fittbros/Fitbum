package com.fitbum.servicios.mapper;



import com.fitbum.dto.RoleDTO;
import com.fitbum.entidades.usuarios.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceMapper extends AbstractServiceMapper<Role, RoleDTO> {

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
