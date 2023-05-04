package com.fitbum.entidades.programa;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name="Sesion")
public class Sesion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;


    @Column
    private String nombreVariante;
    @Column
    private String descripcion;

    @JsonBackReference
    @ManyToOne
    @JoinColumn (name="idMicrociclo",nullable=false)
    private Microciclo microciclo;

    @JsonManagedReference
    @OneToMany(mappedBy = "sesion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<EjercicioForm> ejercicioForm;


}
