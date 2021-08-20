package no.itverket;

public class Game {
    private int totalPoints;

    public void deal(Card card) {
        if (!isGameOver()) {
            totalPoints += Math.min(card.rank, 10);
            System.out.printf("Hit with %s. Total is %s%n", card, totalPoints);
        }
    }

    public boolean isGameOver() {
        return totalPoints > 21;
    }

    public int getTotalPoints() {
        return totalPoints;
    }
}
