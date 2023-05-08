package com.fitbum.servicios.usuarios;

import com.fitbum.dto.UsuarioDto;
import com.fitbum.dto.UsuarioDtoPsw;
import com.fitbum.entidades.usuarios.Role;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.repositorios.usuarios.RoleRepositorio;
import com.fitbum.repositorios.usuarios.UsuarioRepositorio;
import com.fitbum.servicios.mapper.UsuarioMapper;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Getter
@Service
public class UsuarioServicio extends UsuarioMapper {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepositorio roleRepositorio;



    public List<Usuario> listartodos(){
        List<Usuario> usuarioList = usuarioRepositorio.findAll();
        return usuarioRepositorio.findAll();

    }
    public Usuario buscarporemail(String username){
        Usuario usuario = usuarioRepositorio.findUsuarioByUsername(username);
        return usuario;

    }

    public UsuarioDto guardar(UsuarioDto usuarioDto, String password){
        System.out.println("usuarioDto:" +usuarioDto.getUsername() );
        //Traduzco del dto con datos de entrada a la entidad
        final Usuario entidad = this.mapToUser(usuarioDto);
        System.out.println("Entidad:" +entidad.getUsername() );
        entidad.setPassword(password);
        System.out.println("Entidad:" +entidad.getPassword() );
        //Guardo el la base de datos
        Usuario entidadGuardada =  usuarioRepositorio.save(entidad);
        //Traducir la entidad a DTO para devolver el DTO
        return this.mapToUserDto(entidadGuardada);
    }
    public UsuarioDto guardar(UsuarioDtoPsw usuarioDtoPsw){
        System.out.println("usuarioDto:" +usuarioDtoPsw.getUsername() );
        //Traduzco del dto con datos de entrada a la entidad
        final Usuario entidad = this.mapToUserPsw(usuarioDtoPsw);
        System.out.println("Entidad:" +entidad.getUsername() );
        //Guardo el la base de datos
        Usuario entidadGuardada =  usuarioRepositorio.save(entidad);
        //Traducir la entidad a DTO para devolver el DTO
        return this.mapToUserDto(entidadGuardada);
    }

    public void crearUsuario(Usuario usuario){
        Usuario user = new Usuario();
        Optional<Role> rol = roleRepositorio.findById(3);

        usuario.setRole(rol.get());

        usuarioRepositorio.save(usuario) ;
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



