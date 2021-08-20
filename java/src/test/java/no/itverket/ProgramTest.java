package no.itverket;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProgramTest {

    private Deck deck;

    @Before
    public void setUp() {
        deck = new Deck();
    }

    @Test
    public void shouldHave52Cards() {
        Assert.assertEquals(52, deck.cards.size());
    }

    @Test
    public void shouldHave4DistinctSuits() {
        Assert.assertEquals(4, deck.cards.stream().map(c -> c.suit).distinct().count());
    }

    @Test
    public void gameOverWhenPlayerExceeds21Points() {
        Game game = new Game();
        game.deal(new Card(Suit.Hearts, 10));
        game.deal(new Card(Suit.Hearts, 10));
        game.deal(new Card(Suit.Hearts, 2));
        Assert.assertTrue(game.isGameOver());
    }

    @Test
    public void shouldNotDealCardsWhenGameIsOver() {
        Game game = new Game();
        game.deal(new Card(Suit.Hearts, 10));
        game.deal(new Card(Suit.Hearts, 10));
        game.deal(new Card(Suit.Hearts, 2));
        game.deal(new Card(Suit.Hearts, 5));
        Assert.assertEquals(22, game.getTotalPoints());
    }
}