package com.fitbum.entidades.programa;
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
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idSesion;
    @Column
    private Integer idMicrociclo;

    @Column
    private String nombre_variante;
    @Column
    private String descripcion;

    @ManyToOne
    @JoinColumn (name="Microciclo",nullable=false)
    private Mesociclo micro_sesion;

    @OneToMany(mappedBy = "Sesion", cascade = CascadeType.ALL)
    private Set<Microciclo> sesion_ejer;
}
