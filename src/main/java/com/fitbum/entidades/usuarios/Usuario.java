package com.fitbum.entidades.usuarios;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fitbum.entidades.Mensaje;
import com.fitbum.entidades.Notificacion;
import com.fitbum.entidades.estadisticas.Estadisticas;
import com.fitbum.entidades.plantillas.PlantillaMesociclo;
import com.fitbum.entidades.programa.Mesociclo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Usuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String	nombre;
    private String	apellido1;
    private String	apellido2;
    private String	email;
    private String	avatar;
    private String	password;
    private Float	peso;
    private Float	altura;
    private Integer	sexo;
    private LocalDate fechaNacim;
    @Basic(optional = false)
    private boolean active;
    @JsonManagedReference
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Mesociclo> mesociclo;

    @JsonManagedReference
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Suscripcion> suscripcion;

    @JsonManagedReference
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Estadisticas> estadisticas;





    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idrole")
    private Role role;

    @JsonManagedReference
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Notificacion> notificacion;

    @JsonManagedReference
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PlantillaMesociclo> plantMesociclo;



    @JsonManagedReference
    @OneToMany(mappedBy = "relaEntrenador", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Relaciones> relaEntrenador;
    @JsonManagedReference
    @OneToMany(mappedBy = "relaCliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Relaciones> relaCliente;
    @JsonManagedReference
    @OneToMany(mappedBy = "emisor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Mensaje> emisor;
    @JsonManagedReference
    @OneToMany(mappedBy = "receptor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Mensaje> receptor;


}
