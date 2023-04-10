package com.fitbum.Fitbum.rrhh.models;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="DetalleUsuario")
public class DetalleUsuario {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer	idDetalleUsuario;
    private String	nombre;
    private String	apellido1;
    private String	apellido2;
    private String	email;
    private String	password;
    private Float	peso;
    private Float	altura;
    private Integer	sexo;
    private LocalDate fechaNacim;

    public DetalleUsuario(String nombre, String apellido1) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
    }

    public DetalleUsuario(String nombre, String apellido1, String apellido2, String email, String password, Float peso, Float altura, Integer sexo, LocalDate fechaNacim) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email = email;
        this.password = password;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
        this.fechaNacim = fechaNacim;
    }
}
