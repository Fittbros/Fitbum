package com.fitbum.servicios.programas;

import com.fitbum.entidades.plantillas.PlantillaMesociclo;
import com.fitbum.entidades.programa.Mesociclo;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.repositorios.programa.MesocicloRepositorio;
import com.fitbum.servicios.AbstractBusinessServiceSoloEnt;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Getter
@Service
public class MesocicloServicio extends AbstractBusinessServiceSoloEnt<Mesociclo,Integer,MesocicloRepositorio> {
    @Autowired
    private MesocicloRepositorio mesocicloRepositorio;

    protected MesocicloServicio(MesocicloRepositorio mesocicloRepositorio) {
        super(mesocicloRepositorio);
    }

    public List<Mesociclo> listartodos(){
        List<Mesociclo> mesocicloList = mesocicloRepositorio.findAll();
        return mesocicloRepositorio.findAll();

    }
    public Optional<Mesociclo> findById(Integer id){
        return mesocicloRepositorio.findById(id);
    }
}
