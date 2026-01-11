package com.alura.LiterAlura.Model;

import java.util.List;
import java.util.stream.Collectors;

public class Libro {

    private Long id;
    private String titulo;
    private List<Autor> autores;
    private List<String> lenguajes;
    private int totalDeDescargas;

    public Libro(DatosLibro datosLibro) {
        this.titulo = datosLibro.titulo();
        this.autores = datosLibro.autores();
        this.lenguajes = datosLibro.lenguajes();
        this.totalDeDescargas = datosLibro.totalDeDescargas();
    }

    // Getters y setters correctos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<String> getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(List<String> lenguajes) {
        this.lenguajes = lenguajes;
    }

    public int getTotalDeDescargas() {
        return totalDeDescargas;
    }

    public void setTotalDeDescargas(int totalDeDescargas) {
        this.totalDeDescargas = totalDeDescargas;
    }
}
