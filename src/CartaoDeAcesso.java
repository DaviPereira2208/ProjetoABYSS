public class CartaoDeAcesso extends Item {

    private String nome;
    private int nivelAcesso;

    public CartaoDeAcesso(String nome, int nivelAcesso) {
        super(nome);
        this.nome = nome;
        this.nivelAcesso = nivelAcesso;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void usar() {
        IO.println("Esse cartão precisa ser usado em uma porta");
    }

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void exibirInformacoes() {
        IO.println("=== CARTÃO DE ACESSO ===");
        IO.println("Nome: " + nome);
        IO.println("Nivel de Acesso: " + nivelAcesso);
    }
}
