public class JogoDaVelha {

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

    public boolean verificarVitoria(char jogador) {
        //linhas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) {
                return true;
            }
        }

        //colunas
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] == jogador && tabuleiro[1][j] == jogador && tabuleiro[2][j] == jogador) {
                return true;
            }
        }

        if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) {
            return true;
        }

        if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador) {
            return true;
        }

        return false;
    }

    public boolean deuVelha() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false; //se houver alguma casa vazia ele retorna false e o jogo continua
                }
            }
        }
        System.out.println("deu velha!");
        return true; //se estiver tudo cheio, jogo finaliza
    }

}
