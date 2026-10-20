public class KitMedico extends Item {

    private int quantidadeCura;

    public KitMedico() {
        super("Kit Médico");
        this.quantidadeCura = 40;
    }

    public void usar(Jogador jogador) {
        if (jogador == null) {
            IO.println("Nenhum jogador disponível para receber cura.");
            return;
        }

        if (jogador.getVida() <= 0) {
            IO.println("Julian está derrotado e não pode usar o kit.");
            return;
        }

        if (jogador.getVida() >= jogador.getVidaMaxima()) {
            IO.println("A vida de Julian já está cheia!");
            return;
        }

        jogador.recuperarVida(quantidadeCura);
        IO.println("Kit médico utilizado!");
    }

    @Override
    public void usar() {
        IO.println("Selecione Julian como alvo para usar o kit médico.");
    }
}
