package com.fitbum.servicios.usuarios;

import com.fitbum.dto.UsuarioDto;
import com.fitbum.dto.UsuarioDtoPsw;
import com.fitbum.entidades.usuarios.Role;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.repositorios.usuarios.RoleRepositorio;
import com.fitbum.repositorios.usuarios.UsuarioRepositorio;
import com.fitbum.servicios.AbstractBusinessService;
import com.fitbum.servicios.AbstractBusinessServiceSoloEnt;
import com.fitbum.servicios.mapper.UsuarioMapper;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Getter
@Service
public class UsuarioServicio extends AbstractBusinessService<Usuario,Integer,UsuarioDto,UsuarioRepositorio,UsuarioMapper> {



    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepositorio roleRepositorio;
//Acceso a los datos de la bbdd

    public UsuarioServicio (UsuarioRepositorio repo,UsuarioMapper serviceMapper) {



        super(repo, serviceMapper);

    }



    public List<Usuario> listartodos(){
        List<Usuario> usuarioList = getRepo().findAll();
        return getRepo().findAll();

    }
    public Usuario buscarporemail(String username){
        Usuario usuario = getRepo().findUsuarioByUsername(username);
        return usuario;

    }

    public UsuarioDto guardar(UsuarioDto usuarioDto, String password){
        System.out.println("usuarioDto:" +usuarioDto.getUsername() );
        //Traduzco del dto con datos de entrada a la entidad
        final Usuario entidad = this.getMapper().mapToUser(usuarioDto);
        System.out.println("Entidad:" +entidad.getUsername() );
        entidad.setPassword(password);
        System.out.println("Entidad:" +entidad.getPassword() );
        //Guardo el la base de datos
        Usuario entidadGuardada =  getRepo().save(entidad);
        //Traducir la entidad a DTO para devolver el DTO
        return this.getMapper().mapToUserDto(entidadGuardada);
    }
    public UsuarioDto guardar(UsuarioDtoPsw usuarioDtoPsw){
        System.out.println("usuarioDto:" +usuarioDtoPsw.getUsername() );
        //Traduzco del dto con datos de entrada a la entidad
        final Usuario entidad = this.getMapper().mapToUserPsw(usuarioDtoPsw);
        System.out.println("Entidad:" +entidad.getUsername() );
        //Guardo el la base de datos
        Usuario entidadGuardada =  getRepo().save(entidad);
        //Traducir la entidad a DTO para devolver el DTO
        return this.getMapper().mapToUserDto(entidadGuardada);
    }

    public void crearUsuario(Usuario usuario){
        Usuario user = new Usuario();
        Optional<Role> rol = roleRepositorio.findById(3);

        usuario.setRole(rol.get());

        getRepo().save(usuario) ;
    }

}



