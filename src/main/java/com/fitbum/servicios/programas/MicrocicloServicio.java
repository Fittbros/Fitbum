package com.fitbum.servicios.programas;

import com.fitbum.entidades.programa.Mesociclo;
import com.fitbum.entidades.programa.Microciclo;
import com.fitbum.repositorios.programa.MesocicloRepositorio;
import com.fitbum.repositorios.programa.MicrocicloRepositorio;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
public class MicrocicloServicio  {
    @Autowired
    private MicrocicloRepositorio microcicloRepositorio;
    public List<Microciclo> listartodos(){
        List<Microciclo> microciclolist = microcicloRepositorio.findAll();
        return microcicloRepositorio.findAll();

    }
}
