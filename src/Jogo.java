import java.util.Scanner;

public class Jogo {

    private DeckOfCards deck;
    private Dealer dealer;
    private Jogador jogador1;
    private Jogador jogador2;
    private int numJogadores;
    private Scanner input;

    public Jogo(DeckOfCards deck, Dealer dealer, Jogador jogador1, Jogador jogador2, int numJogadores, Scanner input) {
        this.deck = deck;
        this.dealer = dealer;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.numJogadores = numJogadores;
        this.input = input;
    }

    public void iniciajogo() {
        jogador1.resetMao();
        dealer.resetMao();
        if (numJogadores == 2) {
            jogador2.resetMao();
        }

        dealer.fistHand(deck.dealCard(), deck.dealCard());
        jogador1.fistHand(deck.dealCard(), deck.dealCard());
        if (numJogadores == 2) {
            jogador2.fistHand(deck.dealCard(), deck.dealCard());
        }
        System.err.println("=====================Mesa=====================");
        dealer.maoDealerInicial();
        jogador1.mostrarMao();
        if (numJogadores == 2) {
            jogador2.mostrarMao();
        }
        System.err.println("=============================================");
        turnoJogador(jogador1);
        if (numJogadores == 2) {
            turnoJogador(jogador2);
        }
        System.err.println("=============================================");
        turnoDealer();
        System.err.println("=============================================");
        System.out.println("Resultados:");
        jogador1.mostrarMao();
        if (numJogadores == 2) {
            jogador2.mostrarMao();
        }
        dealer.mostrarMao();
        resultado(jogador1);
        if (numJogadores == 2) {

            resultado(jogador2);
        }
        System.err.println("=============================================");
    }

    private void turnoJogador(Jogador jogador) {
        input.nextLine();
        while (true) {
            if (jogador.getPontos() == 21) {
                System.out.println(jogador.getNome() + " fez Black Jack!");
                break;
            }
            System.out.println(jogador.getNome() + ", deseja 'Hit' ou 'Stand'? (h/s)");
            String escolha = input.nextLine().trim().toLowerCase();
            if (escolha.equals("h")) {
                jogador.Hit(deck.dealCard());
                jogador.mostrarMao();

                if (jogador.getPontos() > 21) {
                    System.out.println(jogador.getNome() + " estourou! Pontos: " + jogador.getPontos());
                    break;
                }
            } else if (escolha.equals("s")) {
                System.out.println(jogador.getNome() + " escolheu Stand com pontos: " + jogador.getPontos());
                break;
            } else {
                System.out.println("Escolha inválida. Por favor, digite 'h' para Hit ou 's' para Stand.");
            }
        }
    }

    private void turnoDealer() {
        System.out.println("Turno do Dealer:");
        dealer.mostrarMao();

        int alvo = Integer.MAX_VALUE;

        if (jogador1.getPontos() <= 21) {
            alvo = jogador1.getPontos();
        }

        if (numJogadores == 2 && jogador2.getPontos() <= 21 && jogador2.getPontos() < alvo) {
            alvo = jogador2.getPontos();
        }

        if (alvo > 21) {
            System.out.println("Todos os jogadores estouraram! Dealer não precisa tirar cartas.");
            return;
        }

        while (dealer.getPontos() <= alvo && dealer.getPontos() <= 21) {
            dealer.Hit(deck.dealCard());
            dealer.mostrarMao();
            System.err.println("=============================================");

            if (dealer.getPontos() == 21) {
                System.out.println("Dealer fez Black Jack!");
                break;
            }

            if (dealer.getPontos() > 21) {
                System.out.println("Dealer estourou!");
                break;
            }
        }

        System.out.println("Dealer parou com " + dealer.getPontos() + " pontos.");
    }

    private void resultado(Jogador jogador) {
        if (jogador.getPontos() == 21) {
            System.err.println(jogador.getNome() + " fez Black Jack e venceu!");
        } else if (jogador.getPontos() > 21) {
            System.err.println(jogador.getNome() + " estourou e perdeu!");
        } else if (dealer.getPontos() > 21) {
            System.err.println(jogador.getNome() + " venceu! Dealer estourou!");
        } else if (jogador.getPontos() > dealer.getPontos()) {
            System.err.println(jogador.getNome() + " venceu!");
        } else {
            System.err.println(jogador.getNome() + " perdeu para o Dealer!");
        }
    }
}
