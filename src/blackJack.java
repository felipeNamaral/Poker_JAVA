import java.util.Scanner;

public class blackJack {

     public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("   Bem-vindo ao Black Jack!      ");
        System.out.println("=================================\n");

        System.out.println("Pressione Enter para começar o jogo...");
        input.nextLine();

        
 

        int numJogadores = 0;

        do {
            System.out.print("Digite o número de jogadores (1-2): ");
            numJogadores = input.nextInt();
            input.nextLine();
        } while (numJogadores != 1 && numJogadores != 2);

        System.err.println("Digite o nome do Jogador 1: ");
        String nome1 = input.next();
        Jogador jogador1 = new Jogador(nome1);

        Jogador jogador2 = null;
        if(numJogadores == 2){
            System.err.println("Digite o nome do Jogador 2: ");

            String nome2 = input.next();
            jogador2 = new Jogador(nome2);
        }
        
        Dealer dealer = new Dealer();


        while(true){

            DeckOfCards myDeckOfCards = new DeckOfCards(); 
            myDeckOfCards.shuffle();
            Jogo jogo = new Jogo(myDeckOfCards, dealer, jogador1, jogador2, numJogadores,input);
            jogo.iniciajogo();



            System.err.println("Quer continuar jogando? (s/n)");
            String resposta = input.next();
            if(resposta.equalsIgnoreCase("n")){
                System.out.println("Obrigado por jogar! Até a próxima.");
                break;
         }
    }
}  
}
