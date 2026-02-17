package com.alura.LiterAlura.Service;


import com.alura.LiterAlura.Model.Autor;
import com.alura.LiterAlura.Repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public void listarAutores() {
        List<Autor> autores = autorRepository.findAll();
        autores.forEach(System.out::println);
    }


    public List<Autor> autoresVivosEnAnio(int anio) {
        return autorRepository.encontrarAutoresVivosEnAnio(anio);
    }
}
