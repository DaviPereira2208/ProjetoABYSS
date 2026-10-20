public class Arma {

    private String nome;
    private int dano;
    private int municao;

    public Arma(String nome, int dano, int municao) {
        this.nome = nome;
        this.dano = dano;
        this.municao = municao;
    }

    public String getNome() {
        return nome;
    }

    public int getDano() {
        return dano;
    }

    public int getMunicao() {
        return municao;
    }

    public void disparar() {
        if (municao <= 0) {
            System.out.println("Sem munição!");
            return;
        }

        municao--;
        System.out.println(nome + " disparou! Dano: " + dano);
        System.out.println("Munição restante: " + municao);
    }
}