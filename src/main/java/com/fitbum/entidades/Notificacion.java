package com.fitbum.entidades;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fitbum.entidades.usuarios.Usuario;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer idNotificacion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaEnvio;
    private String texto;
    private Boolean leido;
    private Boolean eliminar;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;






}
