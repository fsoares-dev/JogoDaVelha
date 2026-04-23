import java.util.Scanner;

public class JogoDaVelha {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        JogoDaVelha jogo = new JogoDaVelha();
        jogo.inicializarTabuleiro();
        jogo.exibirTabuleiro();
    }

    char[][] tabuleiro = new char[3][3];

    public void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    public void exibirTabuleiro() {
        System.out.println("  0   1   2");

        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            System.out.println(tabuleiro[i][0] + " | " + tabuleiro[i][1] + " | " + tabuleiro[i][2]);
            if (i < 2) {
                System.out.println(" ---+---+---");
            }
        }
    }

    public boolean fazerJogada(int linha, int coluna, char jogador) {
        if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
            return false; //verifico se o tamanho dos arrays estao corretos
        }

        if (tabuleiro[linha][coluna] == ' ') {
            tabuleiro[linha][coluna] = jogador;
            return true;
        }
        return false;
    }

}
