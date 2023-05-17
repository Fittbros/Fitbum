package com.fitbum.entidades.programa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fitbum.entidades.plantillas.PlantillaMesociclo;
import com.fitbum.entidades.plantillas.PlantillaMicrociclo;
import com.fitbum.entidades.plantillas.PlantillaSesion;
import com.fitbum.entidades.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@DynamicUpdate
@Table(name="Mesociclo")

public class Mesociclo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;


    @Column
    private Integer orden;
    @Column
    private Integer numMicrociclos ;
    @Column
    private Integer frEntreSemana ;
    @Column
    private Integer longMicrociclo;
    @Column
    private String descansoBas ;
    @Column
    private String descansoAcces ;
    @Column
    private String descripcion;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaInicio ;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaFin;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @JsonManagedReference
    @OneToMany(mappedBy = "mesociclo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Microciclo> microciclos;

    public Mesociclo(PlantillaMesociclo plantillaMesociclo){
        this.descripcion=plantillaMesociclo.getDescripcion();
        this.orden=plantillaMesociclo.getOrden();
        this.descansoAcces=plantillaMesociclo.getDescansoAcces();
        this.descansoBas=plantillaMesociclo.getDescansoBas();
        this.fechaFin=plantillaMesociclo.getFechaFin();
        this.fechaInicio=plantillaMesociclo.getFechaInicio();
        this.frEntreSemana=plantillaMesociclo.getFrEntreSemana();
        this.longMicrociclo=plantillaMesociclo.getLongMicrociclo();
        this.numMicrociclos=plantillaMesociclo.getNumMicrociclos();
        List<PlantillaMicrociclo>plantillaMicrocicloList=plantillaMesociclo.getPlantillasMicrociclo();
        List<Microciclo> microciclos= new ArrayList<Microciclo>();
        for (PlantillaMicrociclo plantillaMicrociclo : plantillaMicrocicloList){

          Microciclo microciclo=new Microciclo(plantillaMicrociclo);
          microciclo.setMesociclo(this);
          microciclos.add(microciclo);
          this.microciclos = microciclos;
        }



    }
    }

