package com.alura.LiterAlura.Service;


import com.alura.LiterAlura.Model.DatosLibro;
import com.alura.LiterAlura.Model.Libro;
import com.alura.LiterAlura.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


}
