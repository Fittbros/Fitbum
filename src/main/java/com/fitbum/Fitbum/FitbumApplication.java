package com.fitbum.Fitbum;

import com.fitbum.Fitbum.entidades.DetalleUsuario;
import com.fitbum.Fitbum.repositories.DetalllesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class FitbumApplication {
	@Autowired
	DetalllesRepositorio detalllesRepositorio;



	public static void main(String[] args) {
		SpringApplication.run(FitbumApplication.class, args);
	}


	public void run(String... args) throws Exception {
		//DetalleUsuario usuario = new DetalleUsuario("Pepe","Lopez");
		DetalleUsuario usuario2 = new DetalleUsuario("Jose","Wright","mari","jos1@gmail.com","1234",80.0f,1.80f,1, LocalDate.of(1982,5,13));

		//detalllesRepositorio.save(usuario);
		detalllesRepositorio.save(usuario2);
	}

}
