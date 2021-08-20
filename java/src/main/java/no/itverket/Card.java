package no.itverket;

class Card {
    Suit suit;
    int rank;

    Card(Suit suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        String[] rankDisplay = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        return suit + " " + rankDisplay[rank - 1];
    }
}
