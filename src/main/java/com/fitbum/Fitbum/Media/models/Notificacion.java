package com.fitbum.Fitbum.Media.models;
import jakarta.persistence.Id;

import java.time.LocalDate;
public class Notificacion {

    @Id
    private int idnotificacion;


    private LocalDate fecha_envio;
    private String texto;
    private boolean leido, eliminar;






}
