package ConversorMoneda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteAPI {
    private static final String API_KEY = "f16f51052b1e7f10f992a815";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static String getRates(String baseCurrency) throws IOException, InterruptedException {
        String url = BASE_URL + API_KEY + "/latest/" + baseCurrency;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}

