package modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class ConsultaCep {
    
    public Endereco buscaEndereco(String cep) {
        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
         .uri(endereco)
         .build();

         HttpResponse<String> response;
        try {
            response = HttpClient
                .newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Endereco.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não consegui obter o endereço a partir desse CEP.");
        }

        
    }
}
