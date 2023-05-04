package com.fitbum.servicios.usuarios;

import com.fitbum.dto.UsuarioDto;
import com.fitbum.dto.UsuarioDtoPsw;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.repositorios.usuarios.UsuarioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private PasswordEncoder passwordEncoder;



    public List<Usuario> listartodos(){
        List<Usuario> usuarioList = usuarioRepositorio.findAll();
        return usuarioRepositorio.findAll();

    }
    public Usuario buscarporemail(String email){
        Usuario usuario = usuarioRepositorio.findUsuarioByEmail(email);
        return usuario;

    }
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
    public UsuarioDto guardar(UsuarioDto usuarioDto, String password){
        System.out.println("usuarioDto:" +usuarioDto.getNombreUsuario() );
        //Traduzco del dto con datos de entrada a la entidad
        final Usuario entidad = this.mapToUser(usuarioDto);
        System.out.println("Entidad:" +entidad.getNombre() );
        entidad.setPassword(password);
        System.out.println("Entidad:" +entidad.getPassword() );
        //Guardo el la base de datos
        Usuario entidadGuardada =  usuarioRepositorio.save(entidad);
        //Traducir la entidad a DTO para devolver el DTO
        return this.mapToUserDto(entidadGuardada);
    }
    public UsuarioDto guardar(UsuarioDtoPsw usuarioDtoPsw){
        System.out.println("usuarioDto:" +usuarioDtoPsw.getNombreUsuario() );
        //Traduzco del dto con datos de entrada a la entidad
        final Usuario entidad = this.mapToUserPsw(usuarioDtoPsw);
        System.out.println("Entidad:" +entidad.getNombre() );
        //Guardo el la base de datos
        Usuario entidadGuardada =  usuarioRepositorio.save(entidad);
        //Traducir la entidad a DTO para devolver el DTO
        return this.mapToUserDto(entidadGuardada);
    }

//    public Usuario guardarUsuarioDTO(UserDto userDto) {
//        // Crear un nuevo objeto Usuario
//        Usuario usuario = new Usuario();
//
//        // Configurar los campos del objeto Usuario
//        usuario.setNombre(userDto.getFirstName() + userDto.getLastName());
//        usuario.setEmail(userDto.getEmail());
//        usuario.setUsername(userDto.getUsername());
//
//        // Codificar la contraseña del usuario utilizando el algoritmo de hash BCrypt
//        usuario.setPassword(passwordEncoder.encode(userDto.getPassword()));
//
//        // Guardar el objeto Usuario en la base de datos y devolverlo
//        return usuarioRepository.save(usuario);
//    }
}



