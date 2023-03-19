
package com.fitbum.Fitbum.entidades;
import jakarta.persistence.*;

@Entity
@Table(name="Microciclo")
public class Microciclo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idMicrociclo;

    private int idMesociclo;
    private float volumen_estandar;

    private float intensidad_estandar;

}
