package no.itverket;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        final Game game = new Game();
        final Deck deck = new Deck();

        final Scanner scanner = new Scanner(System.in);
        while (!game.isGameOver()) {
            System.out.println("Stand, Hit");
            final String read = scanner.nextLine();

            if (read.equals("Hit")) {
                game.deal(deck.cards.remove());
            } else if (read.equals("Stand")) {
                break;
            }
        }
        System.out.println("Game over");
    }
}
