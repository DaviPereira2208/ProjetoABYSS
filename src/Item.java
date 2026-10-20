public class Item {

    private String nome;

    public Item(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void usar() {
        System.out.println("Você usou: " + nome);
    }
}


