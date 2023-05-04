package com.fitbum.entidades.plantillas;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fitbum.entidades.programa.Mesociclo;
import com.fitbum.entidades.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@DynamicUpdate
@Table(name="PlantillaMesociclo")

public class PlantillaMesociclo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;//entrenador (usuario con idRol = 2)


 @JsonManagedReference
@OneToMany(mappedBy = "plantillaMesociclo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private Set<PlantillaMicrociclo> plantillaMicrociclo;


    @Column
    private Integer idMesociclos;


    @Column
    private Integer numMicrociclos;

    @Column
    private Integer frEntreSemana;

    @Column
    private Integer longMicrociclo;

    @Column
    private String 	descansoBas;

    @Column
    private String 	descansoAcces;

    @Column
    private String 	descripcion;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaInicio;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaFin;

}
