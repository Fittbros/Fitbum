package com.fitbum.dto;

import com.fitbum.entidades.Mensaje;
import com.fitbum.entidades.Notificacion;
import com.fitbum.entidades.estadisticas.Estadisticas;
import com.fitbum.entidades.plantillas.PlantillaMesociclo;
import com.fitbum.entidades.programa.Mesociclo;
import com.fitbum.entidades.usuarios.Relaciones;
import com.fitbum.entidades.usuarios.Role;
import com.fitbum.entidades.usuarios.Suscripcion;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDtoPsw {

    private Integer idUsuario;
    private String	NombreUsuario;
    private String	nombre;
    private String	apellido1;
    private String	apellido2;
    private String	email;
    private String  password;
    private Float	peso;
    private Float	altura;
    private Integer	sexo;
    private LocalDate fechaNacim;

    private Integer admin;
    private Set<Mesociclo> mesociclo;
    private Set<Suscripcion> suscripcion;
    private List<Estadisticas> estadisticas;
    private Role role;
    private Set<Notificacion> notificacion;
    private Set<PlantillaMesociclo> plantMesociclo;
    private Set<Relaciones> relaEntrenador;
    private Set<Relaciones> relaCliente;
    private Set<Mensaje> emisor;
    private Set<Mensaje> receptor;

}