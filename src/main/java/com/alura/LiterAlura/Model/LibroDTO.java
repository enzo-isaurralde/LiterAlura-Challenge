package com.alura.LiterAlura.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroDTO(
        Long id,
       @JsonAlias ("title") String titulo,
        @JsonAlias ("authors")List<Autor> autores,
        @JsonAlias("lenguages")List<String> lenguajes,
        @JsonAlias("download_count") int totalDeDescargas
) {
}

