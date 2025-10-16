public class Dealer extends Jogador {

    public Dealer() {
        super("Dealer");
    }
    


    public void maoDealerInicial() {
        System.out.println("Dealer mostra: " + getMao().get(0));
        System.out.println("Segunda carta está oculta");
    }

    
}
