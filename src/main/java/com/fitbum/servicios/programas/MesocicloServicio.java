package com.fitbum.servicios.programas;

import com.fitbum.entidades.programa.Mesociclo;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.repositorios.programa.MesocicloRepositorio;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
public class MesocicloServicio {
    @Autowired
    private MesocicloRepositorio mesocicloRepositorio;
    public List<Mesociclo> listartodos(){
        List<Mesociclo> mesocicloList = mesocicloRepositorio.findAll();
        return mesocicloRepositorio.findAll();

    }

}
