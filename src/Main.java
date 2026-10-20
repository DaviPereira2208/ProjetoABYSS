public class Main {

    public static void main(String[] args) {
        Jogador jogador = new Jogador("Julian Reed", 100);

        Arma pistola = new Arma("Pistola", 25, 6);

        jogador.equiparArma(pistola);
        jogador.atacar();
        jogador.atacar();

        Infectado infectado = new Infectado("Infectado do Setor A");

        infectado.atacar();
        jogador.atacar(infectado);

        IO.println("Vida do infectado: " + infectado.getVida());


        Rasgado rasgado = new Rasgado("Rasgado do Setor B");

        rasgado.atacar();
        jogador.atacar(rasgado);

        IO.println("Vida restante do Rasgado: " + rasgado.getVida());


        Observador observador = new Observador("Observador do Setor C");

        observador.atacar();
        jogador.atacar(observador);

        IO.println("Vida restante do Observador: " + observador.getVida());


        Paciente03 caleb = new Paciente03("Caleb Vance");

        IO.println("=== CHEFE: PACIENTE 03 ===");
        caleb.atacar();

        jogador.atacar(caleb);

        IO.println("Vida restante de Caleb: " + caleb.getVida());

    }
}
