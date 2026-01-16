package com.alura.LiterAlura.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroDTO(
        Long id,
       @JsonAlias ("title") String titulo,
        @JsonAlias ("authors") Set<Autor> autores,
        @JsonAlias("lenguages")Set<String> lenguajes,
        @JsonAlias("download_count") int totalDeDescargas
) {
}

