import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorQuery {
    public ExchangeRateAPI rate(String coin) {
        URI url = URI.create("https://v6.exchangerate-api.com/v6/e02888de115e295e2dbce1ea/latest/" + coin);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ExchangeRateAPI.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
