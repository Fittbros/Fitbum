package com.fitbum.Fitbum;

import com.fitbum.Fitbum.repositories.DetalllesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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




}
