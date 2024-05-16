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

        switch (opcao) {
            case 1:
                converterDolarParaPesoArgentino();
                break;
            case 2:
                converterPesoArgentinoParaDolar();
                break;
            case 3:
                converterDolarParaRealBrasileiro();
                break;
            case 4:
                converterRealBrasileiroParaDolar();
                break;
            case 5:
                converterDolarParaPesoColombiano();
                break;
            case 6:
                converterPesoColombianoParaDolar();
                break;
        }
    }

    private void obterTaxasDeConversao() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/SUAAPIAKI/latest/USD"))
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

    private void converterDolarParaPesoArgentino() {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o valor em dólares: ");
        double valorEmDolares = leitura.nextDouble();
        double valorEmPesosArgentino = valorEmDolares * pesoArgentino;
        System.out.println("O valor em pesos argentinos é: " + valorEmPesosArgentino);
    }

    private void converterPesoArgentinoParaDolar() {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o valor em pesos argentinos: ");
        double valorEmPesosArgentino = leitura.nextDouble();
        double valorEmDolares = valorEmPesosArgentino / pesoArgentino;
        System.out.println("O valor em dólares é: " + valorEmDolares);
    }

    private void converterDolarParaRealBrasileiro() {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o valor em dólares: ");
        double valorEmDolares = leitura.nextDouble();
        double valorEmReais = valorEmDolares * realBrasileiro;
        System.out.println("O valor em reais brasileiros é: " + valorEmReais);
    }

    private void converterRealBrasileiroParaDolar() {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o valor em reais brasileiros: ");
        double valorEmReais = leitura.nextDouble();
        double valorEmDolares = valorEmReais / realBrasileiro;
        System.out.println("O valor em dólares é: " + valorEmDolares);
    }

    private void converterDolarParaPesoColombiano() {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o valor em dólares: ");
        double valorEmDolares = leitura.nextDouble();
        double valorEmPesosColombiano = valorEmDolares * pesoColombiano;
        System.out.println("O valor em pesos colombianos é: " + valorEmPesosColombiano);
    }

    private void converterPesoColombianoParaDolar() {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o valor em pesos colombianos: ");
        double valorEmPesosColombiano = leitura.nextDouble();
        double valorEmDolares = valorEmPesosColombiano / pesoColombiano;
        System.out.println("O valor em dólares é: " + valorEmDolares);
    }
}