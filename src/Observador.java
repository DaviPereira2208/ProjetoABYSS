public class Observador extends Criatura {

    public Observador(String nome) {
        super(nome, 50, 15, "Observador");
    }

    @Override
    public void atacar() {
        IO.println(getNome() + " observa você nas sombras...");
        IO.println(getNome() + " ataca de surpresa!");
    }
}
