public abstract class Personagem {

    private String nome;
    private int vida;
    private int nivelInfeccao;

    public Personagem(String nome, int vida) {
        this.nome = nome;
        this.vida = vida;
        this.nivelInfeccao = 0;
    }

    public void receberDano(int dano) {
        if (dano <= 0) {
            return;
        }

        vida -= dano;

        if (vida < 0) {
            vida = 0;
        }
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

    public int getNivelInfeccao() {
        return nivelInfeccao;
    }

    public abstract void atacar();
}

