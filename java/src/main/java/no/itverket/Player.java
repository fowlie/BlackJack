package no.itverket;

public class Player {
    private int totalPoints;

    public void hit(Card card) {
        if (!hasLost()) {
            int points = Math.min(card.rank, 10);
            totalPoints += getPointsFromAce(points);
            System.out.printf("%s hit with %s. Total is %s%n", this.getClass().getSimpleName(), card, totalPoints);
        }
    }

    public boolean hasLost() {
        return totalPoints > 21;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    private int getPointsFromAce(int rank) {
        return rank == 1 ? (totalPoints < 11 ? 11 : 1) : rank;
    }

    public static class Dealer extends Player {}
}
