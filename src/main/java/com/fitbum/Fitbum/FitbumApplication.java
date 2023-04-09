package com.fitbum.Fitbum;

<<<<<<< Updated upstream
=======
import com.fitbum.Fitbum.entidades.DetalleUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
>>>>>>> Stashed changes
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class FitbumApplication {

<<<<<<< Updated upstream
=======
	@Autowired


>>>>>>> Stashed changes
	public static void main(String[] args) {
		SpringApplication.run(FitbumApplication.class, args);
	}


}
