package com.fitbum.servicios.usuarios;

import com.fitbum.dto.UsuarioDto;
import com.fitbum.dto.UsuarioDtoPsw;
import com.fitbum.entidades.usuarios.DetalleUsuario;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.repositorios.usuarios.DetallesRepositorio;
import com.fitbum.repositorios.usuarios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio {
    @Autowired
    private DetallesRepositorio detallesRepositorio;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<DetalleUsuario> getAll(){return detallesRepositorio.findAll();}

    public UsuarioDto mapToUserDto(Usuario user,DetalleUsuario det){
        UsuarioDto userDto = new UsuarioDto();
        userDto.setNombreUsuario(det.getNombre()+" "+det.getApellido1()+" "+det.getApellido2());
        userDto.setEmail(det.getEmail());
        userDto.setRole(user.getRole().getIdRole());
        return userDto;
    }
    public UsuarioDtoPsw mapToUserDtoPsw(Usuario user,DetalleUsuario det){
        UsuarioDtoPsw userDto = new UsuarioDtoPsw();
        userDto.setNombreUsuario(det.getNombre()+" "+det.getApellido1()+" "+det.getApellido2());
        userDto.setEmail(det.getEmail());
        userDto.setRole(user.getRole().getIdRole());
        userDto.setPassword(det.getPassword());
        return userDto;
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



