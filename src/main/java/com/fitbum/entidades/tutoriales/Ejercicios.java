package com.fitbum.entidades.tutoriales;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="Ejercicios")
public class Ejercicios {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)

   private Integer idEjercicio;
   private Integer idTutorial;

   private String nombre;
   private String descripcion;
   private String grupo_muscular;
   private String mascara_gen_progresion;




}
