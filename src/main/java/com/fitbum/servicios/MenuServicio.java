package com.fitbum.servicios;

import com.fitbum.dto.MenuDTO;
import com.fitbum.entidades.Menu;
import com.fitbum.entidades.usuarios.Role;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.repositorios.MenuRepositorio;

import com.fitbum.repositorios.usuarios.RoleRepositorio;
import com.fitbum.repositorios.usuarios.UsuarioRepositorio;
import com.fitbum.servicios.mapper.MenuServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service


public class MenuServicio extends AbstractBusinessService<Menu, Integer, MenuDTO, MenuRepositorio, MenuServiceMapper>{
    @Autowired
    private  MenuRepositorio menuRepositorio;
    private UsuarioRepositorio usuarioRepositorio;

    private  RoleRepositorio roleRepositorio;


    @Autowired
    protected MenuServicio(MenuRepositorio repository, MenuServiceMapper serviceMapper,
                          UsuarioRepositorio usuarioRepository, RoleRepositorio roleRepository) {
        super(repository, serviceMapper);
        this.usuarioRepositorio = usuarioRepository;
        this.roleRepositorio = roleRepository;
    }



    public List<Menu> findAll() {
        return menuRepositorio.findAll();
    }
    public Optional<Menu> findById(Integer id) {
        return menuRepositorio.findById(id);
    }
    public  Menu save(Menu menu) {
        return menuRepositorio.save(menu);
    }
    public void deleteById(Integer id) {
        menuRepositorio.deleteById(id);
    }
    public List<MenuDTO> getMenuForRole(Collection<Role> roles) {
        List<Menu> menus = this.getRepo().findDistinctByRolesInAndActivoTrueOrderByOrden(roles);
        return this.getMapper().toDto(menus);
    }
    public List<MenuDTO> getMenuForEmail(String email) {
        Usuario usuario = this.usuarioRepositorio.findUsuarioByEmailAndActiveTrue(email);
        return getMenuForRole(Collections.singleton(usuario.getRole()));
    }

    public List<MenuDTO> getMenuForUsername(String username) {
        Usuario usuario = this.usuarioRepositorio.findUsuarioByUsernameAndActiveTrue(username);
        return getMenuForRole(Collections.singleton(usuario.getRole()));
    }
}
