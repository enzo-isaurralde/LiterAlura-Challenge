package com.alura.LiterAlura.Repository;

import com.alura.LiterAlura.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    // Buscar por título (contiene, sin importar mayúsculas/minúsculas)
    @EntityGraph(attributePaths = {"autores", "lenguajes"})
    List<Libro> findByTituloContainingIgnoreCase(String titulo);

    // Libros por idioma (contiene, sin importar mayúsculas/minúsculas)
    @EntityGraph(attributePaths = {"autores", "lenguajes"})
    List<Libro> findByLenguajesContainingIgnoreCase(String lenguaje);

    @EntityGraph(attributePaths = {"autores", "lenguajes"})
    List<Libro> findAll();

    @EntityGraph(attributePaths = {"autores", "lenguajes"})
    @Query("SELECT l FROM Libro l")
    List<Libro> findAllWithAutores();


}
