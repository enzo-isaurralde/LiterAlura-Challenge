package com.alura.LiterAlura.Principal;

import com.alura.LiterAlura.Model.DatosLibro;
import com.alura.LiterAlura.Model.Libro;
import com.alura.LiterAlura.Model.RespuestaGutendex;
import com.alura.LiterAlura.Service.ConsumoAPI;
import com.alura.LiterAlura.Service.ConvierteDatos;
import com.alura.LiterAlura.Model.DatosLibro;

import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/?search=Romeo+and+Juliet";
    private ConvierteDatos conversor = new ConvierteDatos();

    public void buscarLibroWeb() {
        DatosLibro datos = getDatosLibro();
        System.out.println(datos);
        Libro libro = new Libro(datos);
        System.out.println(datos);
    }

    private DatosLibro getDatosLibro() {
        System.out.println("Ingrese el título del libro que desea buscar:");
        var nombreLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE+nombreLibro.replace(" ","+" ));
        System.out.println("JSON recibido:" + json);
        RespuestaGutendex respuesta = conversor.obtenerDatos(json, RespuestaGutendex.class);

        if (respuesta.results().isEmpty()) {
            throw new RuntimeException("No se encontraron libros con ese título.");
        }

        return respuesta.results().get(0); // primer libro


    }
}

