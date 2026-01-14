package main.java.com.alura.LiterAlura.Repository;

import main.java.com.alura.LiterAlura.Model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository <Autor, Long> {
    @Query("SELECT a FROM Autor a WHERE a.birthYear <= :anio AND (a.deathYear IS NULL OR a.deathYear > :anio)")
    List<Autor> encontrarAutoresVivosEnAnio(@Param("anio") int anio); }

