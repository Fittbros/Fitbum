package com.fitbum.Fitbum.programa.models;

import jakarta.persistence.Id;

public class Ejercicio {

   @Id
   private int idEjercicio, idTutorial;

   private String nombre, descripcion, grupo_muscular;



}
