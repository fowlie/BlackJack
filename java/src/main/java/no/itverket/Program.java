package no.itverket;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) {
        final Player dealer = new Player.Dealer();
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

        System.out.printf("%n%s win!%n", Stream.of(dealer, player)
                .filter(p -> !p.hasLost())
                .max(Comparator.comparingInt(Player::getTotalPoints))
                .orElseThrow(IllegalStateException::new)
                .getClass().getSimpleName());
    }
}
