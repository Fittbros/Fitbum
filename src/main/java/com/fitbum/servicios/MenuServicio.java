package com.fitbum.servicios;

import com.fitbum.entidades.Menu;
import com.fitbum.repositorios.MenuRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service


public class MenuServicio {
    @Autowired
    private MenuRepositorio menuRepositorio;
    public List<Menu> findAll() {
        return menuRepositorio.findAll();
    }
    public Optional<Menu> findById(Integer id) {
        return menuRepositorio.findById(id);
    }
    public Menu save(Menu menu) {
        return menuRepositorio.save(menu);
    }
    public void deleteById(Integer id) {
        menuRepositorio.deleteById(id);
    }
}
