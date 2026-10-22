
import java.util.ArrayList;

public class Sala {

    private String nome;
    private String descricao;
    private ArrayList<Item> itens;
    private Porta portaAcesso;
    private ArrayList<Criatura> criaturas;
    private ArrayList<Sala> salasConectadas;

    public Sala(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.itens = new ArrayList<>();
        this.criaturas = new ArrayList<>();
        this.salasConectadas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void definirPortaAcesso(Porta porta) {
        this.portaAcesso = porta;
    }

    public boolean podeEntrar() {
        return portaAcesso == null || portaAcesso.isAberta();
    }

    public void conectarSala(Sala sala) {
        if (sala == null || sala == this) {
            IO.println("Não foi possível conectar essa sala.");
            return;
        }

        if (!salasConectadas.contains(sala)) {
            salasConectadas.add(sala);
            IO.println(nome + " conectada a " + sala.getNome());
        }
    }

    public ArrayList<Sala> getSalasConectadas() {
        return new ArrayList<>(salasConectadas);
    }

    public void adicionarItem(Item item) {
        if (item == null) {
            IO.println("Não é possível adicionar um item inválido.");
            return;
        }

        itens.add(item);
        IO.println(item.getNome() + " foi colocado na sala.");
    }

    public void adicionarCriatura(Criatura criatura) {
        if (criatura == null) {
            IO.println("Não é possível adicionar uma criatura inválida.");
            return;
        }

        criaturas.add(criatura);
        IO.println(criatura.getNome() + " foi colocado na sala.");
    }

    public void explorar() {
        if (!podeEntrar()) {
            IO.println("ACESSO BLOQUEADO!");
            IO.println("Você precisa abrir a porta para entrar nesta sala.");
            return;
        }

        IO.println("=== " + nome.toUpperCase() + " ===");
        IO.println(descricao);

        if (itens.isEmpty()) {
            IO.println("Não há itens nesta sala.");
        } else {
            IO.println("Itens encontrados:");

            for (int i = 0; i < itens.size(); i++) {
                IO.println((i + 1) + ". " + itens.get(i).getNome());
            }
        }

        if (criaturas.isEmpty()) {
            IO.println("Nenhuma criatura detectada.");
        } else {
            IO.println("!!! CRIATURAS DETECTADAS !!!");

            for (Criatura criatura : criaturas) {
                IO.println("Presença detectada: " + criatura.getNome());
            }
        }

        if (salasConectadas.isEmpty()) {
            IO.println("Não há saídas conhecidas desta sala.");
        } else {
            IO.println("Saídas disponíveis:");

            for (int i = 0; i < salasConectadas.size(); i++) {
                Sala sala = salasConectadas.get(i);

                String status = sala.podeEntrar()
                        ? "Disponível"
                        : "Bloqueada";

                IO.println((i + 1) + ". " + sala.getNome()
                        + " - " + status);
            }
        }
    }

    public void coletarItem(int indice, Jogador jogador) {
        if (jogador == null || jogador.getVida() <= 0) {
            IO.println("Julian não pode coletar itens agora.");
            return;
        }

        if (indice < 0 || indice >= itens.size()) {
            IO.println("Índice de item inválido.");
            return;
        }

        Item item = itens.remove(indice);
        jogador.coletarItem(item);

        IO.println("Item coletado da sala: " + item.getNome());
    }
}
