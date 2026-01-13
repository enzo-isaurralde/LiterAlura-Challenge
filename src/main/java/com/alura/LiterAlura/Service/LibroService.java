package com.alura.LiterAlura.Service;


import com.alura.LiterAlura.Model.DatosLibro;
import com.alura.LiterAlura.Model.Libro;
import com.alura.LiterAlura.Model.LibroDTO;
import com.alura.LiterAlura.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;
    @Transactional
    public Libro guardarLibro(DatosLibro datosLibro) {
        Libro libro = new Libro(datosLibro);
        return libroRepository.save(libro);
    }
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }
    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }
    public List<Libro> buscarPorTitulo(String titulo) {
        return libroRepository.findByTituloContainingIgnoreCase(titulo);
    }

    // Nuevo: devolver DTOs en lugar de entidades para mostrar al usuario.
    @Transactional(readOnly = true)
    public List<LibroDTO> buscarDtoPorTitulo(String titulo) {
        return libroRepository.findByTituloContainingIgnoreCase(titulo)
                .stream()
                .map(l -> new LibroDTO(
                        l.getId(),
                        l.getTitulo(),
                        l.getAutores(),
                        l.getLenguajes(),
                        l.getTotalDeDescargas()
                ))
                .collect(Collectors.toList());
    }

    public  List<Libro> buscarPorIdioma(String lenguajes) {
        return libroRepository.findByLenguajesContainingIgnoreCase(lenguajes);
    }
}
