package com.alura.LiterAlura;

import com.alura.LiterAlura.Principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.alura.LiterAlura.Principal.Principal;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}
Principal principal = new Principal();
    @Override
    public void run(String... args) throws Exception {
        principal.buscarLibroWeb();
    }
}
