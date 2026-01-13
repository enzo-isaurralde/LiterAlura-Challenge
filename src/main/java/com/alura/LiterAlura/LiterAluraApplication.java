package com.alura.LiterAlura;


import com.alura.LiterAlura.Controller.LibroController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

    private final LibroController libroController;

    public LiterAluraApplication(LibroController libroController) {
        this.libroController = libroController;
    }

    public static void main(String[] args) {
        SpringApplication.run(LiterAluraApplication.class, args);
    }

    @Override
    public void run(String... args) {
        libroController.mostrarMenu();
    }
}
