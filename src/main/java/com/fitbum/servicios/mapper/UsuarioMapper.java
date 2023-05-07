package com.fitbum.servicios.mapper;

import com.fitbum.dto.UsuarioDto;
import com.fitbum.dto.UsuarioDtoPsw;
import com.fitbum.entidades.usuarios.Usuario;
import org.modelmapper.ModelMapper;

public class UsuarioMapper {
    public UsuarioDto mapToUserDto(Usuario user){
        UsuarioDto userDto = new UsuarioDto();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(user,userDto);
        userDto.setNombreUsuario(user.getNombre()+" "+user.getApellido1()+" "+user.getApellido2());
        return userDto;
    }
    public UsuarioDtoPsw mapToUserDtoPsw(Usuario user){
        UsuarioDtoPsw userDto = new UsuarioDtoPsw();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(user,userDto);
        userDto.setNombreUsuario(user.getNombre()+" "+user.getApellido1()+" "+user.getApellido2());
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
}
