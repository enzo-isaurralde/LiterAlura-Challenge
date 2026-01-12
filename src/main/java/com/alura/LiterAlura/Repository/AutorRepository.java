package com.alura.LiterAlura.Repository;

import com.alura.LiterAlura.Model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository <Autor, Long> {
}
