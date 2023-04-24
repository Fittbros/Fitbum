package com.fitbum.entidades.programa;

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
@Table(name="Mesociclo")

public class Mesociclo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer idUsuario;
    @Column
    private Integer num_micro ;
    @Column
    private Integer fr_entreno ;
    @Column
    private Integer long_micro;
    @Column
    private Integer desc_bas ;
    @Column
    private Integer desc_acc ;
    @Column
    private String descripcion;
    @Column
    private Date fecha_inicio ;
    @Column
    private Date fecha_fin;

    @ManyToOne
    @JoinColumn (name="Usuario",nullable=false)
    private Usuario usuariomesociclo;

    @OneToMany(mappedBy = "Mesociclo", cascade = CascadeType.ALL)
    private Set<Microciclo> meso_microciclo;


}
