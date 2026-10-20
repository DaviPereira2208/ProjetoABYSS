public class Paciente03 extends Criatura {

    public Paciente03(String nome) {
        super(nome, 150, 30, "Paciente 03");
    }

    @Override
    public void atacar() {
        if (getVida() <= 0) {
            IO.println(getNome() + " foi derrotado e não pode atacar.");
            return;
        }

        IO.println(getNome() + " ruge de forma aterrorizante!");
        IO.println(getNome() + " avança brutalmente contra sua vítima!");
    }

    public void atacar(Jogador jogador) {
        if (getVida() <= 0) {
            IO.println(getNome() + " foi derrotado e não pode atacar.");
            return;
        }

        if (jogador == null) {
            IO.println("Nenhum jogador disponível como alvo.");
            return;
        }

        if (jogador.getVida() <= 0) {
            IO.println(jogador.getNome() + " já foi derrotado.");
            return;
        }

        jogador.receberDano(getDano());

        IO.println(getNome() + " atingiu " + jogador.getNome() + "!");
        IO.println("Dano causado: " + getDano());
        IO.println("Vida restante de " + jogador.getNome() + ": " + jogador.getVida());

        if (jogador.getVida() <= 0) {
            IO.println(jogador.getNome() + " foi derrotado!");
        }
    }
}