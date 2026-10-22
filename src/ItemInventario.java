public class ItemInventario {

    private Item item;
    private int quantidade;

    public ItemInventario(Item item) {
        this.item = item;
        this.quantidade = 1;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void adicionarQuantidade() {
        quantidade++;
    }

    public void removerQuantidade() {
        if (quantidade > 0) {
            quantidade--;
        }
    }
}

