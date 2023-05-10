package com.fitbum.servicios.tutoriales;

import com.fitbum.entidades.Menu;
import com.fitbum.entidades.tutoriales.Ejercicios;
import com.fitbum.repositorios.programa.EjerciciosRepositorio;
import com.fitbum.servicios.AbstractBusinessService;
import com.fitbum.servicios.AbstractBusinessServiceSoloEnt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class EjerciciosServicio extends AbstractBusinessServiceSoloEnt<Ejercicios, Integer, EjerciciosRepositorio> {
    @Autowired
    protected EjerciciosServicio(EjerciciosRepositorio ejerciciosRepositorio) {
        super(ejerciciosRepositorio);

    }



}
