package com.alura.LiterAlura.Model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    // Relación unidireccional: Libro -> Autor
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "libro_id")
    private Set<Autor> autores;

    @ElementCollection
    private Set<String> lenguajes;


    private int totalDeDescargas;

    public Libro() {
        // constructor vacío obligatorio para JPA
    }

    public Libro(DatosLibro datosLibro) {
        this.titulo = datosLibro.titulo();
        this.autores = datosLibro.autores().stream()
                .map(AutorDTO::toEntity)
                .collect(Collectors.toSet());
        this.lenguajes = datosLibro.lenguajes();
        this.totalDeDescargas = datosLibro.totalDeDescargas();
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Set<Autor> getAutores() { return autores; }
    public void setAutores(Set<Autor> autores) { this.autores = autores; }

    public Set<String> getLenguajes() { return lenguajes; }
    public void setLenguajes(Set<String> lenguajes) { this.lenguajes = lenguajes; }

    public int getTotalDeDescargas() { return totalDeDescargas; }
    public void setTotalDeDescargas(int totalDeDescargas) { this.totalDeDescargas = totalDeDescargas; }
}
