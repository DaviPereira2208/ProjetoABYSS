public class Rasgado extends Criatura {

    public Rasgado(String nome) {
        super(nome, 80, 20, "Rasgado");
    }

    @Override
    public void atacar() {
        IO.println(getNome() + " desfere um golpe violento!");
    }
}
