package main.java.com.alura.LiterAlura.Service;


import main.java.com.alura.LiterAlura.Model.Autor;
import main.java.com.alura.LiterAlura.Repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    public List<Autor> autoresVivosEnAnio(int anio) {
        return autorRepository.encontrarAutoresVivosEnAnio(anio);
    }
}
