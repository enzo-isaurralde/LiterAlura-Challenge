package com.alura.LiterAlura.Service;

import com.alura.LiterAlura.Model.*;
import com.alura.LiterAlura.Repository.AutorRepository;
import com.alura.LiterAlura.Repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;
    private final ConsumoAPI consumoApi = new ConsumoAPI();
    private final ConvierteDatos conversor = new ConvierteDatos();
    private final String URL_BASE = "https://gutendex.com/books/?search=";

    public LibroService(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    // 🔎 Buscar libro por título (BD primero, luego API)
    public List<LibroDTO> buscarDtoPorTitulo(String titulo) {
        List<Libro> encontrados = libroRepository.findByTituloContainingIgnoreCase(titulo);

        if (!encontrados.isEmpty()) {
            return encontrados.stream()
                    .map(l -> new LibroDTO(
                            l.getId(),
                            l.getTitulo(),
                            l.getAutores(),
                            l.getLenguajes(),
                            l.getTotalDeDescargas()
                    ))
                    .collect(Collectors.toList());
        }

        // Si no está en BD, buscar en la API
        DatosLibro datos = buscarLibroWeb(titulo);
        if (datos == null) {
            return Collections.emptyList();
        }

        // Crear entidad y guardar en BD
        Libro libro = new Libro(datos);
        libroRepository.save(libro);

        return List.of(new LibroDTO(
                libro.getId(),
                libro.getTitulo(),
                libro.getAutores(),
                libro.getLenguajes(),
                libro.getTotalDeDescargas()
        ));
    }

    // 📚 Listar todos los libros registrados
    public List<LibroDTO> listarLibros() {
        return libroRepository.findAll().stream()
                .map(l -> new LibroDTO(
                        l.getId(),
                        l.getTitulo(),
                        l.getAutores(),
                        l.getLenguajes(),
                        l.getTotalDeDescargas()
                ))
                .collect(Collectors.toList());
    }

    // 🌍 Listar libros por idioma
    public List<LibroDTO> listarLibrosPorIdioma(String idioma) {
        return libroRepository.findByLenguajesContainingIgnoreCase(idioma).stream()
                .map(l -> new LibroDTO(
                        l.getId(),
                        l.getTitulo(),
                        l.getAutores(),
                        l.getLenguajes(),
                        l.getTotalDeDescargas()
                ))
                .collect(Collectors.toList());
    }

    // ⚙️ Método auxiliar para consultar la API
    private DatosLibro buscarLibroWeb(String titulo) {
        String url = URL_BASE + URLEncoder.encode(titulo, StandardCharsets.UTF_8);
        String json = consumoApi.obtenerDatos(url);
        RespuestaGutendex respuesta = conversor.obtenerDatos(json, RespuestaGutendex.class);

        if (respuesta.results().isEmpty()) {
            return null;
        }
        return respuesta.results().get(0); // primer resultado
    }
}
