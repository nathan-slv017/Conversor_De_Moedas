import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        int opcao = 0;
        do {
            System.out.println("""
                    ******************************************************************
                    Seja bem-vindo(a) ao Conversor de Moeda =]
                    
                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar =>> Real brasileiro
                    4) Real Brasileiro =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Sair
                    Escolha uma opção válida:
                    ******************************************************************""");
                Scanner leitura = new Scanner(System.in);
                opcao = leitura.nextInt();
                if (opcao > 7 || opcao < 1) {
                    opcao = 7;
                }
                if (opcao != 7) {
                    Conversor conversor = new Conversor();
                    conversor.executarConversao(opcao);
                }
        } while (opcao != 7);
        System.out.println("Conversor de Moedas finalizado");
    }
}