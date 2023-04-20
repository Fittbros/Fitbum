package com.fitbum.entidades.usuarios;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fitbum.entidades.Notificacion;
import com.fitbum.entidades.estadisticas.Estadisticas;
import com.fitbum.entidades.plantillas.PlantillaMesociclo;
import com.fitbum.entidades.programa.Mesociclo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Usuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUsuario;

    private Integer detalle_usuario_idDetalle_usuario;
    private Integer roles_idRoles;
    private Integer admin;
    //Falta relacion mensajes, relaciones,
    @JsonManagedReference
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PlantillaMesociclo> plantillaMesociclo;

    @JsonManagedReference
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Suscripcion> suscripcion;

    @JsonManagedReference
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Estadisticas> estadisticas;

    @JsonManagedReference
    @OneToOne @MapsId
    DetalleUsuario detalleUsuario;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idRol")
    private Rol rol;

    @JsonManagedReference
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Notificacion> notificacion;

    @JsonManagedReference
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Mesociclo> mesociclo;


}
