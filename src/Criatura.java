public abstract class Criatura extends Personagem implements Contaminavel {

    private int dano;
    private String tipo;

    public Criatura(String nome, int vida, int dano, String tipo) {
        super(nome, vida);
        this.dano = dano;
        this.tipo = tipo;
    }

    public int getDano() {
        return dano;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public void contaminar() {
        System.out.println(getNome() + " está espalhando a contaminação!");
    }

    public void atacar(Personagem alvo) {
        if (alvo != null && getVida() > 0) {
            alvo.receberDano(dano);

            System.out.println(
                    getNome() + " causou " + dano +
                            " de dano em " + alvo.getNome() + "."
            );
        }
    }

    @Override
    public abstract void atacar();
}

