package main.java.com.alura.LiterAlura.Service;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class ConsumoAPI {

    public String obtenerDatos(String url) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body(); // acá ya tenés el JSON como String
        } catch (Exception e) {
            throw new RuntimeException("Error al consumir la API", e);
        }
    }
}
