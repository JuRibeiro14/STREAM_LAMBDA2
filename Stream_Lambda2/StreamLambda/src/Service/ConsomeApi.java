package Service;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ConsomeApi {
    public String consomeApi() throws IOException, InterruptedException {
        String url = "https://api.escuelajs.co/api/v1/products/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        return response.body();
    }
}