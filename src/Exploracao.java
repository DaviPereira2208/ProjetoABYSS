import java.util.ArrayList;
import java.util.Scanner;

public class Exploracao {

    private Jogador jogador;
    private Sala salaAtual;
    private Scanner scanner;

    public Exploracao(Jogador jogador, Sala salaInicial) {
        this.jogador = jogador;
        this.salaAtual = salaInicial;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        if (jogador == null || salaAtual == null) {
            IO.println("Não foi possível iniciar a exploração.");
            return;
        }

        IO.println("=== PROJECT: ABYSS ===");
        IO.println("Você é " + jogador.getNome() + ".");
        salaAtual.explorar();

        boolean executando = true;

        while (executando && jogador.getVida() > 0) {
            IO.println("\n=== MENU DE EXPLORAÇÃO ===");
            IO.println("Local atual: " + salaAtual.getNome());
            IO.println("1. Explorar sala");
            IO.println("2. Coletar item");
            IO.println("3. Viajar para outra sala");
            IO.println("4. Consultar inventário");
            IO.println("5. Sair do jogo");
            IO.print("Escolha: ");

            String entrada = scanner.nextLine();
            int opcao;

            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                IO.println("Digite um número de 1 a 5.");
                continue;
            }

            switch (opcao) {
                case 1:
                    salaAtual.explorar();
                    break;

                case 2:
                    coletarItem();
                    break;

                case 3:
                    viajarParaOutraSala();
                    break;

                case 4:
                    jogador.getInventario().listarItens();
                    break;

                case 5:
                    IO.println("Encerrando exploração...");
                    executando = false;
                    break;

                default:
                    IO.println("Opção inválida.");
            }
        }

        if (jogador.getVida() <= 0) {
            IO.println("Julian não pode continuar. Fim de jogo.");
        }

        IO.println("Obrigado por jogar PROJECT: ABYSS.");
    }

    private void coletarItem() {
        IO.println("=== COLETAR ITEM ===");

        // Mostra os itens encontrados na sala.
        salaAtual.explorar();

        IO.print("Digite o número do item para coletar: ");

        try {
            int indice = Integer.parseInt(scanner.nextLine()) - 1;
            salaAtual.coletarItem(indice, jogador);
        } catch (NumberFormatException e) {
            IO.println("Digite um número válido.");
        }
    }

    private void viajarParaOutraSala() {
        ArrayList<Sala> salas = salaAtual.getSalasConectadas();

        if (salas.isEmpty()) {
            IO.println("Não há saídas desta sala.");
            return;
        }

        IO.println("=== SAÍDAS DISPONÍVEIS ===");

        for (int i = 0; i < salas.size(); i++) {
            Sala destino = salas.get(i);

            String status = destino.podeEntrar()
                    ? "Disponível"
                    : "BLOQUEADA";

            IO.println((i + 1) + ". "
                    + destino.getNome() + " - " + status);
        }

        IO.println("0. Cancelar");
        IO.print("Para onde deseja ir? ");

        try {
            int escolha = Integer.parseInt(scanner.nextLine());

            if (escolha == 0) {
                IO.println("Viagem cancelada.");
                return;
            }

            if (escolha < 1 || escolha > salas.size()) {
                IO.println("Saída inválida.");
                return;
            }

            Sala destino = salas.get(escolha - 1);

            if (!destino.podeEntrar()) {
                IO.println("ACESSO BLOQUEADO!");
                IO.println("Você precisa liberar a porta primeiro.");
                return;
            }

            salaAtual = destino;
            jogador.mover("para " + salaAtual.getNome());

            IO.println("Você chegou a: " + salaAtual.getNome());
            salaAtual.explorar();

        } catch (NumberFormatException e) {
            IO.println("Digite um número válido.");
        }
    }
}
