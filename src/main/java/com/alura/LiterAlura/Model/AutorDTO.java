package com.alura.LiterAlura.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AutorDTO(
        @JsonProperty("name") String name,
        @JsonProperty("birth_year") Integer birthYear,
        @JsonProperty("death_year") Integer deathYear
) {
    public Autor toEntity() {
        return new Autor(name, birthYear, deathYear);
    }
}
