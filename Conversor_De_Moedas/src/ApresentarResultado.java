import java.util.Scanner;

public class ApresentarResultado {
    public void converteGeral(double moeda, boolean divideOuNao, String primeiraMensagem, String segundaMensagem) {
        Scanner leitura = new Scanner(System.in);
        System.out.println(primeiraMensagem);
        double valorEmPesosColombiano = leitura.nextDouble();
        double valorEmDolares = divideOuNao ? valorEmPesosColombiano * moeda : valorEmPesosColombiano / moeda;
        System.out.println(segundaMensagem + valorEmDolares);
    }
}
