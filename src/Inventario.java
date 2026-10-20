import java.util.ArrayList;
import java.util.List;


public class Inventario {

    private List<Item> itens;
    public Inventario() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        if (item != null) {
            itens.add(item);
            IO.println(item.getNome() + "foi adicionado ao inventario.");
        }
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            IO.println("O inventario está vazio.");
            return;
        }

        for (Item item : itens) {
            IO.println(item.getNome());
        }
    }

    public List<Item> getItens() {
        return itens;
    }
}


