import java.util.Scanner;

public class ConversaoMoeda {
    private double dolar;
    private double pesoArgentino;
    private double realBrasileiro;
    private double pesoColombiano;

        public ConversaoMoeda(double dolar, double pesoArgentino, double realBrasileiro, double pesoColombiano) {
        this.dolar = dolar;
        this.pesoArgentino = pesoArgentino;
        this.realBrasileiro = realBrasileiro;
        this.pesoColombiano = pesoColombiano;
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