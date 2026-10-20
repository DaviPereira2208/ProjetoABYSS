public abstract class Personagem {

    private String nome;
    private int vida;
    private int vidaMaxima;
    private int nivelInfeccao;

    public Personagem(String nome, int vida) {
        this.nome = nome;
        this.vida = Math.max(0, vida);
        this.vidaMaxima = this.vida;
        this.nivelInfeccao = 0;
    }

    public void receberDano(int dano) {
        if (dano <= 0 || vida <= 0) {
            return;
        }

        vida -= dano;

        if (vida < 0) {
            vida = 0;
        }
    }

    public void recuperarVida(int quantidade) {
        if (quantidade <= 0 || vida <= 0) {
            IO.println("Não foi possível recuperar a vida.");
            return;
        }

        vida += quantidade;

        if (vida > vidaMaxima) {
            vida = vidaMaxima;
        }

        IO.println(nome + " recuperou vida. Vida atual: " + vida + "/" + vidaMaxima);
    }

    public void aumentarInfeccao(int valor) {
        if (valor <= 0) {
            return;
        }

        nivelInfeccao += valor;

        if (nivelInfeccao > 100) {
            nivelInfeccao = 100;
        }
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getNivelInfeccao() {
        return nivelInfeccao;
    }

    public abstract void atacar();
}

