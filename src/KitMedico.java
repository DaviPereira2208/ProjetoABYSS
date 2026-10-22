public class KitMedico extends Item {

    private int quantidadeCura;

    public KitMedico() {
        super("Kit Médico");
        this.quantidadeCura = 40;
    }

    public boolean usar(Jogador jogador) {
        if (jogador == null) {
            IO.println("Nenhum jogador disponível.");
            return false;
        }

        if (jogador.getVida() <= 0) {
            IO.println("Julian está derrotado e não pode usar o kit.");
            return false;
        }

        if (jogador.getVida() >= jogador.getVidaMaxima()) {
            IO.println("A vida de Julian já está cheia!");
            return false;
        }

        jogador.recuperarVida(quantidadeCura);
        IO.println("Kit médico utilizado!");
        return true;
    }

    @Override
    public void usar() {
        IO.println("Informe o jogador para usar o kit médico.");
    }
}
