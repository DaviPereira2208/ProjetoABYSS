
import java.util.ArrayList;

public class Fase {
    private String nome;
    private ArrayList<Sala> salas;

    public Fase(String nome) {
        this.nome = nome;
        this.salas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarSala(Sala sala) {
        if (sala == null) {
            IO.println("Não é possível adicionar uma sala inválida.");
            return;
        }

        salas.add(sala);
        IO.println(sala.getNome() + " adicionada à fase " + nome + ".");
    }

    public void listarSalas() {
        IO.println("=== FASE: " + nome.toUpperCase() + " ===");

        if (salas.isEmpty()) {
            IO.println("Não há salas nesta fase.");
            return;
        }

        for (int i = 0; i < salas.size(); i++) {
            IO.println((i + 1) + ". " + salas.get(i).getNome());
        }
    }

    public void explorarSala(int indice) {
        if (indice < 0 || indice >= salas.size()) {
            IO.println("Índice de sala inválido.");
            return;
        }

        salas.get(indice).explorar();
    }

    public int getQuantidadeSalas() {
        return salas.size();
    }
}

