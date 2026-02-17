package com.alura.LiterAlura.Controller;

import com.alura.LiterAlura.Service.LibroService;
import com.alura.LiterAlura.Service.AutorService;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class LibroController {

    private final LibroService libroService;
    private final AutorService autorService;
    private final Scanner scanner = new Scanner(System.in);

    public LibroController(LibroService libroService, AutorService autorService) {
        this.libroService = libroService;
        this.autorService = autorService;
    }

    public void mostrarMenu() {
        int opcion = -1;
        do {
            System.out.println("\n=== Menú LiterAlura ===");
            System.out.println("1 - Buscar libro por título");
            System.out.println("2 - Listar libros registrados");
            System.out.println("3 - Listar autores registrados");
            System.out.println("4 - Listar autores vivos en un determinado año");
            System.out.println("5 - Listar libros por idioma");
            System.out.println("0 - Salir");
            System.out.print("Elija la opción: ");
            String input = scanner.nextLine().trim(); // leer como String

            if (input.isEmpty()) {
                // si no escribió nada, sigue en el bucle
                System.out.println("Debe ingresar una opción.");
                continue;
            }

            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida, ingrese un número.");
                continue;
            }

            switch (opcion) {
                case 1 -> buscarLibroPorTitulo();
                case 2 -> listarLibros();
                case 3 -> listarAutores();
                case 4 -> listarAutoresVivos();
                case 5 -> listarLibrosPorIdioma();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }

    private void buscarLibroPorTitulo() {
        System.out.print("Ingrese el título: ");
        String titulo = scanner.nextLine();
        libroService.buscarDtoPorTitulo(titulo)
                .forEach(System.out::println);
    }

    private void listarLibros() {
        libroService.listarLibros()
                .forEach(System.out::println);
    }

    private void listarAutores() {
        autorService.listarAutores();

    }

    private void listarAutoresVivos() {
        System.out.print("Ingrese el año: ");
        int anio = scanner.nextInt();
        scanner.nextLine();
        autorService.autoresVivosEnAnio(anio)
                .forEach(System.out::println);
    }

    private void listarLibrosPorIdioma() {
        System.out.print("Ingrese el idioma (ej: 'es', 'en'): ");
        String idioma = scanner.nextLine();
        libroService.listarLibrosPorIdioma(idioma)
                .forEach(System.out::println);
    }
}
