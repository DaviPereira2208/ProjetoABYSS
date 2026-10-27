
public class Porta {

    private String nome;
    private int nivelAcesso;
    private boolean aberta;

    public Porta(String nome, int nivelAcesso) {
        this.nome = nome;
        this.nivelAcesso = nivelAcesso;
        this.aberta = false;
    }

    public String getNome() {
        return nome;
    }

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public boolean isAberta() {
        return aberta;
    }

    public void abrir(CartaoDeAcesso cartao){

        if(aberta){
            IO.println(nome + " já está aberta.");
            return;
        }

        if (cartao == null) {
            IO.println("Acesso NEGADO!! NENHUM cartão foi apresentado.");
            return;
        }

        if (cartao.getNivelAcesso() >= nivelAcesso){
            aberta = true;
            IO.println("Acesso Autorizado!!");
            IO.println(nome + " foi aberta.");
        }else{
            IO.println("Acesso Negado!!");
            IO.println(" O cartão não possui nivel de acesso necessário.");
        }
    }

    public void fechar(){
        if (!aberta){
            IO.println(nome + " Já está fechada.");
            return;
        }

        aberta = false;
        IO.println(nome + " foi fechada!");
    }
}
