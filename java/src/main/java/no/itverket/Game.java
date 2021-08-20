package no.itverket;

public class Game {
    private int totalPoints;

    public void deal(Card card) {
        if (!isGameOver()) {
            int points = Math.min(card.rank, 10);
            totalPoints += getPointsFromAce(points);
            System.out.printf("Hit with %s. Total is %s%n", card, totalPoints);
        }
    }

    public boolean isGameOver() {
        return totalPoints > 21;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    private int getPointsFromAce(int rank) {
        return rank == 1 ? (totalPoints < 11 ? 11 : 1) : rank;
    }
}
