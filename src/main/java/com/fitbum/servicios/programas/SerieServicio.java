package com.fitbum.servicios.programas;

import com.fitbum.entidades.programa.Serie;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.repositorios.programa.SerieRepositorio;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
public class SerieServicio {
    @Autowired
    private SerieRepositorio serieRepositorio;

    public List<Serie> listartodos(){
        List<Serie> serieList = serieRepositorio.findAll();
        return serieRepositorio.findAll();

    }
}
