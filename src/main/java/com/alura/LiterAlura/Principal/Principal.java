package main.java.com.alura.LiterAlura.Principal;




import main.java.com.alura.LiterAlura.Model.DatosLibro;
import main.java.com.alura.LiterAlura.Model.Libro;
import main.java.com.alura.LiterAlura.Model.RespuestaGutendex;
import main.java.com.alura.LiterAlura.Service.ConsumoAPI;
import main.java.com.alura.LiterAlura.Service.ConvierteDatos;

import java.util.Scanner;

public class Principal {

    private final Scanner teclado = new Scanner(System.in);
    private final ConsumoAPI consumoApi = new ConsumoAPI();
    private final ConvierteDatos conversor = new ConvierteDatos();
    private final String URL_BASE = "https://gutendex.com/books/?search=";

    // Método principal que se llama desde LiterAluraApplication
    public void buscarLibroWeb() {
        DatosLibro datos = getDatosLibro();
        System.out.println("Libro encontrado: " + datos);

        // Crear entidad Libro a partir de los datos
        Libro libro = new Libro(datos);
        System.out.println("Entidad creada: " + libro);
    }

    // Método auxiliar para obtener datos desde la API
    private DatosLibro getDatosLibro() {
        System.out.println("Ingrese el título del libro que desea buscar:");
        String nombreLibro = teclado.nextLine();

        // Consumir API Gutendex
        String json = consumoApi.obtenerDatos(URL_BASE + nombreLibro.replace(" ", "+"));
        System.out.println("JSON recibido: " + json);

        // Convertir JSON a objeto RespuestaGutendex
        RespuestaGutendex respuesta = conversor.obtenerDatos(json, RespuestaGutendex.class);

        if (respuesta.results().isEmpty()) {
            throw new RuntimeException("No se encontraron libros con ese título.");
        }

        // Retornar el primer resultado
        return respuesta.results().get(0);
    }
}
