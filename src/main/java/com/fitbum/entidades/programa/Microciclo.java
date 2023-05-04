
package com.fitbum.entidades.programa;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fitbum.entidades.usuarios.Suscripcion;
import com.fitbum.entidades.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@DynamicUpdate
@Table(name="Microciclo")
public class Microciclo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Float volumenEstandar ;
    @Column
    private Float intensidadEstandar ;
   @Column
    private Integer orden;


    @JsonBackReference
    @ManyToOne
    @JoinColumn (name="Mesociclo",nullable=false)
    private Mesociclo mesociclo;

    @JsonManagedReference
    @OneToMany(mappedBy = "microciclo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Sesion> sesion;


}
