
import java.util.Scanner;

public class Combate {

    private Jogador jogador;
    private Criatura criatura;
    private boolean combateAtivo;

    private Scanner scanner = new Scanner(System.in);

    public Combate(Jogador jogador, Criatura criatura) {
        this.jogador = jogador;
        this.criatura = criatura;
        this.combateAtivo = true;
    }

    public void iniciar() {
        if (jogador == null || criatura == null
                || jogador.getVida() <= 0
                || criatura.getVida() <= 0) {

            IO.println("Não foi possível iniciar o combate.");
            combateAtivo = false;
            return;
        }

        IO.println("=== COMBATE INICIADO ===");
        IO.println(jogador.getNome() + " vs. " + criatura.getNome());

        while (combateAtivo) {
            executarRodada();
        }
    }

    public void executarRodada() {
        if (!combateAtivo) {
            return;
        }

        IO.println("\n=== NOVA RODADA ===");
        IO.println("Vida de " + jogador.getNome() + ": "
                + jogador.getVida() + "/" + jogador.getVidaMaxima());
        IO.println("Vida de " + criatura.getNome() + ": "
                + criatura.getVida() + "/" + criatura.getVidaMaxima());

        IO.println("\nEscolha sua ação:");
        IO.println("1. Atacar");
        IO.println("2. Usar item");
        IO.println("3. Fugir");
        IO.print("Opção: ");

        String entrada = scanner.nextLine();
        int escolha;

        try {
            escolha = Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            IO.println("Opção inválida. Digite 1, 2 ou 3.");
            return;
        }

        switch (escolha) {
            case 1:
                jogador.atacar(criatura);
                break;

            case 2:
                IO.println("=== INVENTÁRIO ===");
                jogador.getInventario().listarItens();
                IO.println("Digite o número do item que deseja usar:");
                IO.println("Digite 0 para cancelar.");
                IO.print("Item: ");

                String entradaItem = scanner.nextLine();
                int indice;

                try {
                    indice = Integer.parseInt(entradaItem);
                } catch (NumberFormatException e) {
                    IO.println("Número inválido.");
                    return;
                }

                if (indice == 0) {
                    IO.println("Uso do item cancelado.");
                    return;
                }

                jogador.usarItemDoInventario(indice - 1);
                break;

            case 3:
                IO.println("Julian tentou fugir do combate!");
                IO.println("Você escapou da batalha.");
                combateAtivo = false;
                return;

            default:
                IO.println("Opção inválida. Escolha 1, 2 ou 3.");
                return;
        }

        finalizarCombate();

        if (!combateAtivo) {
            return;
        }

        // A criatura contra-ataca se ainda estiver viva.
        criatura.atacar(jogador);

        finalizarCombate();
    }

    private void finalizarCombate() {
        if (jogador.getVida() <= 0) {
            IO.println(jogador.getNome() + " foi derrotado!");
            combateAtivo = false;
        } else if (criatura.getVida() <= 0) {
            IO.println(criatura.getNome() + " foi derrotado!");
            combateAtivo = false;
        }
    }

    public boolean isCombateAtivo() {
        return combateAtivo;
    }
}
