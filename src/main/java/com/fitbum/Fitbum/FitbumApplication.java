package com.fitbum.Fitbum;

import com.fitbum.Fitbum.repositories.DetallesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class FitbumApplication {

	@Autowired
	DetallesRepositorio detalllesRepositorio;



	public static void main(String[] args) {
		SpringApplication.run(FitbumApplication.class, args);
	}




}
