package com.fitbum.servicios;

import com.fitbum.dto.MenuDTO;
import com.fitbum.entidades.Menu;
import com.fitbum.repositorios.MenuRepositorio;

import com.fitbum.servicios.mapper.MenuServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service


public class MenuServicio extends AbstractBusinessService<Menu, Integer, MenuDTO, MenuRepositorio, MenuServiceMapper>{
    @Autowired
    private  MenuRepositorio menuRepositorio;





    protected MenuServicio(MenuRepositorio menuRepositorio, MenuServiceMapper mapper) {
        super(menuRepositorio, mapper);
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
}
