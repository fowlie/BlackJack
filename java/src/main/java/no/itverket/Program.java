package no.itverket;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        final Player dealer = new Player();
        final Player player = new Player();
        final Deck deck = new Deck();

        dealer.hit(deck.takeCard());

        final Scanner scanner = new Scanner(System.in);
        while (!player.hasLost()) {
            System.out.println("Stand, Hit");
            final String read = scanner.nextLine();

            if (read.equals("Hit")) {
                player.hit(deck.takeCard());
            } else if (read.equals("Stand")) {
                break;
            }
        }
        while (dealer.getTotalPoints() < 17) {
            dealer.hit(deck.takeCard());
        }
        System.out.println("Game over");
    }
}
