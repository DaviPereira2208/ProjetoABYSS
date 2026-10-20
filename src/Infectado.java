public class Infectado extends Criatura{

    public Infectado(String nome) {
        super(nome, 60, 10, "Infectado");
    }

    @Override
    public void atacar() {
        IO.println(getNome() + " avança com um golpe brutal!");
    }
}
