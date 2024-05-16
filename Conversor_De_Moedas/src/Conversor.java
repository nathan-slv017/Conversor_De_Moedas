import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Conversor {
    private double dolar;
    private double pesoArgentino;
    private double realBrasileiro;
    private double pesoColombiano;

    public void executarConversao(int opcao) throws IOException, InterruptedException {
        obterTaxasDeConversao();

        ApresentarResultado apresentarResultado = new ApresentarResultado();

        switch (opcao) {
            case 1:
                apresentarResultado.converteGeral(pesoArgentino, true, "Digite o valor em dólares: ", "O valor em pesos argentinos é: ");
                break;
            case 2:
                apresentarResultado.converteGeral(pesoArgentino, false, "Digite o valor em pesos argentinos: ", "O valor em dólares é: ");
                break;
            case 3:
                apresentarResultado.converteGeral(realBrasileiro, true, "Digite o valor em dólares: ", "O valor em reais brasileiros é: ");
                break;
            case 4:
                apresentarResultado.converteGeral(realBrasileiro, false, "Digite o valor em reais brasileiros: ", "O valor em dólares é: ");
                break;
            case 5:
                apresentarResultado.converteGeral(pesoColombiano, true, "Digite o valor em dólares: ", "O valor em pesos colombianos é: ");
                break;
            case 6:
                apresentarResultado.converteGeral(pesoColombiano, false, "Digite o valor em pesos colombianos: ", "O valor em dólares é: ");
                break;
        }
    }

    private void obterTaxasDeConversao() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/SUA_API/latest/USD"))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        dolar = conversionRates.get("USD").getAsDouble();
        pesoArgentino = conversionRates.get("ARS").getAsDouble();
        realBrasileiro = conversionRates.get("BRL").getAsDouble();
        pesoColombiano = conversionRates.get("COP").getAsDouble();
    }
}