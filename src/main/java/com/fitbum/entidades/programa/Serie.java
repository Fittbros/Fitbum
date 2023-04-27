package com.fitbum.entidades.programa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@DynamicUpdate
@Table(name="Serie")
public class Serie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;


    @Column
    private Float carga;
    @Column
    private Integer repes;
    @Column
    private String modif_tecnicos;
    @Column
    private String modif_programacion;

    @JsonBackReference
    @ManyToOne
    @JoinColumn (name="idEjercicioForm",nullable=false)
    private EjercicioForm ejercicioForm;


}
