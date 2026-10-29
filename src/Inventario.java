import java.util.ArrayList;

public class Inventario {

    private ArrayList<ItemInventario> itens;

    public Inventario() {
        itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        if (item == null) {
            IO.println("Não foi possível adicionar um item inválido.");
            return;
        }

        for (ItemInventario itemInventario : itens) {
            Item itemExistente = itemInventario.getItem();

            boolean mesmoTipo =
                    itemExistente.getClass() == item.getClass();

            boolean mesmoNome =
                    itemExistente.getNome().equals(item.getNome());

            boolean mesmoNivelAcesso = true;

            if (itemExistente instanceof CartaoDeAcesso cartaoExistente
                    && item instanceof CartaoDeAcesso cartaoNovo) {
                mesmoNivelAcesso =
                        cartaoExistente.getNivelAcesso()
                                == cartaoNovo.getNivelAcesso();
            }

            if (mesmoTipo && mesmoNome && mesmoNivelAcesso) {
                itemInventario.adicionarQuantidade();

                IO.println(item.getNome()
                        + " adicionado. Quantidade: "
                        + itemInventario.getQuantidade());
                return;
            }
        }

        itens.add(new ItemInventario(item));
        IO.println(item.getNome() + " adicionado ao inventário.");
    }

    public void listarItens() {
        IO.println("=== INVENTÁRIO DE JULIAN ===");

        if (itens.isEmpty()) {
            IO.println("O inventário está vazio.");
            return;
        }

        for (int i = 0; i < itens.size(); i++) {
            ItemInventario itemInventario = itens.get(i);

            IO.println((i + 1) + ". "
                    + itemInventario.getItem().getNome()
                    + " x"
                    + itemInventario.getQuantidade());
        }
    }

    public boolean usarItem(int indice, Jogador jogador) {
        if (indice < 0 || indice >= itens.size()) {
            IO.println("Índice de item inválido.");
            return false;
        }

        ItemInventario itemInventario = itens.get(indice);
        Item item = itemInventario.getItem();
        boolean utilizado = false;

        if (item instanceof KitMedico kit) {
            utilizado = kit.usar(jogador);
        } else {
            IO.println("Este item ainda não possui uso implementado.");
        }

        if (utilizado) {
            itemInventario.removerQuantidade();

            if (itemInventario.getQuantidade() == 0) {
                itens.remove(indice);
                IO.println(item.getNome()
                        + " acabou e foi removido do inventário.");
            } else {
                IO.println("Quantidade restante de "
                        + item.getNome() + ": "
                        + itemInventario.getQuantidade());
            }

            return true;
        }

        return false;
    }

    public Item removerItem(int indice) {
        if (indice < 0 || indice >= itens.size()) {
            IO.println("Índice de item inválido.");
            return null;
        }

        ItemInventario itemInventario = itens.get(indice);
        Item item = itemInventario.getItem();

        itemInventario.removerQuantidade();

        if (itemInventario.getQuantidade() == 0) {
            itens.remove(indice);
        }

        return item;
    }

    public int getQuantidadeItens() {
        int total = 0;

        for (ItemInventario itemInventario : itens) {
            total += itemInventario.getQuantidade();
        }

        return total;
    }

    public Item getItem(int indice) {
        if (indice < 0 || indice >= itens.size()) {
            IO.println("Índice de item inválido.");
            return null;
        }

        return itens.get(indice).getItem();
    }
}
