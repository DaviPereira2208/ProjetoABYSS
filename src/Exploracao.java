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
        verificarCriaturas();

        boolean executando = true;

        while (executando && jogador.getVida() > 0) {
            IO.println("\n=== MENU DE EXPLORAÇÃO ===");
            IO.println("Local atual: " + salaAtual.getNome());
            IO.println("1. Explorar sala");
            IO.println("2. Coletar item");
            IO.println("3. Viajar para outra sala");
            IO.println("4. Consultar inventário");
            IO.println("5. Usar cartão de acesso");
            IO.println("6. Usar item");
            IO.println("7. Sair do jogo");
            IO.print("Escolha: ");

            String entrada = scanner.nextLine();
            int opcao;

            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                IO.println("Digite um número de 1 a 6.");
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
                    usarCartaoDeAcesso();
                    break;

                case 6:
                    usarItem();
                    break;

                case 7:
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

            IO.println((i + 1) + ". " + destino.getNome()
                    + " - " + status);
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
            jogador.mover(salaAtual.getNome());

            IO.println("Você chegou a: " + salaAtual.getNome());
            salaAtual.explorar();
            verificarCriaturas();

        } catch (NumberFormatException e) {
            IO.println("Digite um número válido.");
        }
    }

    private void usarCartaoDeAcesso() {
        ArrayList<Sala> salas = salaAtual.getSalasConectadas();
        ArrayList<Sala> salasBloqueadas = new ArrayList<>();

        IO.println("=== CARTÕES DE ACESSO ===");

        for (Sala sala : salas) {
            Porta porta = sala.getPortaAcesso();

            if (porta != null && !porta.isAberta()) {
                salasBloqueadas.add(sala);
            }
        }

        if (salasBloqueadas.isEmpty()) {
            IO.println("Não há portas bloqueadas nas saídas desta sala.");
            return;
        }

        IO.println("Portas bloqueadas:");

        for (int i = 0; i < salasBloqueadas.size(); i++) {
            Sala destino = salasBloqueadas.get(i);
            Porta porta = destino.getPortaAcesso();

            IO.println((i + 1) + ". " + porta.getNome()
                    + " (nível necessário: " + porta.getNivelAcesso() + ")");
        }

        IO.println("0. Cancelar");
        IO.print("Escolha a porta: ");

        try {
            int escolhaPorta = Integer.parseInt(scanner.nextLine());

            if (escolhaPorta == 0) {
                IO.println("Operação cancelada.");
                return;
            }

            if (escolhaPorta < 1 || escolhaPorta > salasBloqueadas.size()) {
                IO.println("Opção de porta inválida.");
                return;
            }

            Sala destino = salasBloqueadas.get(escolhaPorta - 1);
            Porta porta = destino.getPortaAcesso();

            jogador.getInventario().listarItens();

            IO.println("Digite o número do cartão no inventário.");
            IO.println("Digite 0 para cancelar.");
            IO.print("Cartão: ");

            int indiceCartao = Integer.parseInt(scanner.nextLine());

            if (indiceCartao == 0) {
                IO.println("Operação cancelada.");
                return;
            }

            jogador.usarCartaoNaPorta(indiceCartao - 1, porta);

        } catch (NumberFormatException e) {
            IO.println("Digite um número válido.");
        }
    }

    private void verificarCriaturas() {
        Criatura criatura = salaAtual.encontrarCriatura();

        if (criatura == null) {
            return;
        }

        IO.println("\n!!! UMA CRIATURA SE APROXIMA !!!");
        IO.println(criatura.getNome() + " bloqueia seu caminho!");

        Combate combate = new Combate(jogador, criatura);
        combate.iniciar();

        if (jogador.getVida() <= 0) {
            IO.println("Julian não conseguiu sobreviver.");
            return;
        }

        if (criatura.getVida() <= 0) {
            IO.println("A área parece estar segura... por enquanto.");
        }
    }

    private void usarItem() {
        IO.println("=== USAR ITEM ===");
        jogador.getInventario().listarItens();

        IO.println("Digite o número do item que deseja usar.");
        IO.println("Digite 0 para cancelar.");
        IO.print("Item: ");

        try {
            int indice = Integer.parseInt(scanner.nextLine());

            if (indice == 0) {
                IO.println("Uso do item cancelado.");
                return;
            }

            if (indice < 0) {
                IO.println("Índice inválido.");
                return;
            }

            boolean itemUsado = jogador.usarItemDoInventario(indice - 1);

            if (!itemUsado) {
                IO.println("Não foi possível usar esse item.");
            }
        } catch (NumberFormatException e) {
            IO.println("Digite um número válido.");
        }
    }
}