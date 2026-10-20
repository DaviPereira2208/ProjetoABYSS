public class Jogador extends Personagem implements Contaminavel{

    private Inventario inventario;
    private Arma armaAtual;

    public Jogador(String nome, int vida) {
        super(nome, vida);
        this.inventario = new Inventario();
        this.armaAtual = null;
    }

    public void mover(String direcao) {
        if (getVida() <= 0) {
            IO.println(getNome() + " não pode se mover porque foi derrotado.");
            return;
        }

        IO.println(getNome() + " se moveu para " + direcao + ".");
    }

    public void usarItem(Item item) {
        if (getVida() <= 0) {
            IO.println(getNome() + " não pode usar itens porque foi derrotado.");
            return;
        }

        if (item != null) {
            item.usar();
        } else {
            IO.println("Nenhum item disponível.");
        }
    }

    public void equiparArma(Arma arma) {
        if (getVida() <= 0) {
            IO.println(getNome() + " não pode equipar armas porque foi derrotado.");
            return;
        }

        if (arma != null) {
            this.armaAtual = arma;
            IO.println("Arma equipada: " + arma.getNome());
        }
    }

    @Override
    public void atacar() {
        if (getVida() <= 0) {
            IO.println(getNome() + " não pode atacar porque foi derrotado.");
            return;
        }

        if (armaAtual == null) {
            IO.println(getNome() + " está sem arma!");
            return;
        }

        armaAtual.disparar();
    }

    public void atacar(Personagem alvo) {
        if (getVida() <= 0) {
            IO.println(getNome() + " não pode atacar porque foi derrotado.");
            return;
        }

        if (alvo == null) {
            IO.println("Nenhum alvo disponível.");
            return;
        }

        if (alvo.getVida() <= 0) {
            IO.println(alvo.getNome() + " já foi derrotado.");
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

        if (alvo.getVida() <= 0) {
            IO.println(alvo.getNome() + " foi derrotado!");
        }
    }

    @Override
    public void contaminar() {
        if (getVida() <= 0) {
            IO.println(getNome() + " não pode ser contaminado porque foi derrotado.");
            return;
        }

        aumentarInfeccao(10);
        IO.println("A infecção de " + getNome() + " aumentou!");
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void usarKitMedico(KitMedico kit) {
        if (getVida() <= 0) {
            IO.println(getNome() + " não pode usar itens porque foi derrotado.");
            return;
        }

        if (kit == null) {
            IO.println("Nenhum kit médico disponível.");
            return;
        }

        if (getVida() >= getVidaMaxima()) {
            IO.println("A vida de " + getNome() + " já está cheia!");
            return;
        }

        kit.usar(this);
    }
}

