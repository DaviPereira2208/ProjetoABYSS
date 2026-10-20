public class Paciente03 extends Criatura{

    public Paciente03(String nome) {
        super(nome, 150, 30, "Paciente 03");
    }

    @Override
    public void atacar() {
        IO.println(getNome() + " ruge de forma aterrorizante!");
        IO.println(getNome() + " avança brutalmente contra sua vítima!");
    }
}
