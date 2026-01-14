package main.java.com.alura.LiterAlura.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RespuestaGutendex(
        List<DatosLibro> results
) {}
