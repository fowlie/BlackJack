package no.itverket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Deck {
    List<Card> cards;

    Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (int i = 1; i < 14; i++) {
                cards.add(new Card(suit, i));
            }
        }
        Collections.shuffle(cards);
    }

    Card takeCard() {
        return cards.remove(cards.size() - 1);
    }
}
