public class Jogador extends Personagem implements Contaminavel{

    private Inventario inventario;
    private Arma armaAtual;

    public Jogador(String nome, int vida) {
        super(nome, vida);
        this.inventario = new Inventario();
        this.armaAtual = null;
    }

    public void mover(String direcao) {
        IO.println(getNome() + " se moveu para " + direcao + ".");
    }

    public void usarItem(Item item) {
        if (item != null) {
            item.usar();
        } else {
            IO.println("Nenhum item disponível.");
        }
    }

    public void equiparArma(Arma arma) {
        if (arma != null) {
            this.armaAtual = arma;
            IO.println("Arma equipada: " + arma.getNome());
        }
    }

    @Override
    public void atacar() {
        if (armaAtual == null) {
            IO.println(getNome() + " está sem arma!");
            return;
        }

        armaAtual.disparar();
    }

    public void atacar(Personagem alvo) {
        if (alvo == null) {
            IO.println("Nenhum alvo disponível.");
            return;
        }

        if (armaAtual == null) {
            IO.println(getNome() + " está sem arma!");
            return;
        }

        if (armaAtual.getMunicao() <= 0) {
            IO.println("Sem munição!");
            return;
        }

        armaAtual.disparar();
        alvo.receberDano(armaAtual.getDano());

        IO.println("Vida restante de " + alvo.getNome() + ": " + alvo.getVida());
    }

    @Override
    public void contaminar() {
        aumentarInfeccao(10);
        IO.println("A infecção de " + getNome() + " aumentou!");
    }

    public Inventario getInventario() {
        return inventario;
    }
}

