import java.util.Scanner;

public class JogoRolando {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new JogoRolando();
    }

    public JogoRolando() {
        JogoDaVelha jogo = new JogoDaVelha();

        jogo.inicializarTabuleiro();
        char jogadorAtual = 'X';

        int linha;
        int coluna;

        boolean jogadaValida;
        while (true) {
            jogo.exibirTabuleiro();

            do {
                System.out.println("Jogador " + jogadorAtual);
                System.out.print("Digite a linha (0-2): ");
                linha = scanner.nextInt();
                System.out.print("Digite a coluna (0-2): ");
                coluna = scanner.nextInt();

                //crio uma variavel para fazer a verificação da minha jogada, se ela for invalida, retorna, se nao o jogo continua
                jogadaValida = jogo.fazerJogada(linha, coluna, jogadorAtual);

                if (!jogadaValida) {
                    System.out.println("Posição inválida ou ocupada! Tente novamente.");
                    System.out.println();
                }

            } while (!jogadaValida);

            if (jogo.verificarVitoria(jogadorAtual)){
                jogo.exibirTabuleiro();
                System.out.println("Jogador " + jogadorAtual + " venceu!");
                break;
            }

            if (jogo.deuVelha()) {
                jogo.exibirTabuleiro();
                System.out.println("Deu Velha!");
                break;
            }

            if (jogadorAtual == 'X') {
                jogadorAtual = 'O';
            } else {
                jogadorAtual = 'X';
            }
        }
    }
}
