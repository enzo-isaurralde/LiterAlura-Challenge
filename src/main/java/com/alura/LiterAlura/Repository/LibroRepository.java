package com.alura.LiterAlura.Repository;
import com.alura.LiterAlura.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LibroRepository extends JpaRepository <Libro, Long> {

}
