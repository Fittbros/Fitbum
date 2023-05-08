package com.fitbum.servicios.mapper;

import com.fitbum.dto.UsuarioDto;
import com.fitbum.dto.UsuarioDtoPsw;
import com.fitbum.entidades.usuarios.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UsuarioMapper extends AbstractServiceMapper<Usuario, UsuarioDto> {

    public UsuarioDto mapToUserDto(Usuario user){
        UsuarioDto userDto = new UsuarioDto();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(user,userDto);
        userDto.setUsername(user.getUsername());
        return userDto;
    }
    public UsuarioDtoPsw mapToUserDtoPsw(Usuario user){
        UsuarioDtoPsw userDto = new UsuarioDtoPsw();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(user,userDto);
        userDto.setUsername(user.getUsername());
        return userDto;
    }

    public Usuario mapToUserPsw(UsuarioDtoPsw usuarioDtoPsw){
        Usuario user = new Usuario();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(usuarioDtoPsw,user);
        return user;
    }

    public Usuario mapToUser(UsuarioDto usuarioDto){
        Usuario user = new Usuario();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(usuarioDto,user);
        return user;
    }

    @Override
    public UsuarioDto toDto(Usuario usuario) {
        return null;
    }

    @Override
    public Usuario toEntity(UsuarioDto usuarioDto) throws Exception {
        return null;
    }
}
