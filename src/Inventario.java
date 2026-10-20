import java.util.ArrayList;
import java.util.List;


public class Inventario {

    private ArrayList<Item> itens;

    public Inventario() {
        itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        if (item == null) {
            IO.println("Não foi possível adicionar um item inválido.");
            return;
        }

        itens.add(item);
        IO.println(item.getNome() + " adicionado ao inventário.");
    }

    public void listarItens() {
        IO.println("=== INVENTÁRIO DE JULIAN ===");

        if (itens.isEmpty()) {
            IO.println("O inventário está vazio.");
            return;
        }

        for (int i = 0; i < itens.size(); i++) {
            IO.println((i + 1) + ". " + itens.get(i).getNome());
        }
    }

    public Item removerItem(int indice) {
        if (indice < 0 || indice >= itens.size()) {
            IO.println("Índice de item inválido.");
            return null;
        }

        return itens.remove(indice);
    }

    public int getQuantidadeItens() {
        return itens.size();
    }
}