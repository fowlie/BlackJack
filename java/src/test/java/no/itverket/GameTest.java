package no.itverket;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

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
        Player game = new Player();
        game.hit(new Card(Suit.Hearts, 10));
        game.hit(new Card(Suit.Hearts, 10));
        game.hit(new Card(Suit.Hearts, 2));
        Assert.assertTrue(game.hasLost());
    }

    @Test
    public void shouldNotDealCardsWhenGameIsOver() {
        Player game = new Player();
        game.hit(new Card(Suit.Hearts, 10));
        game.hit(new Card(Suit.Hearts, 10));
        game.hit(new Card(Suit.Hearts, 2));
        game.hit(new Card(Suit.Hearts, 5));
        Assert.assertEquals(22, game.getTotalPoints());
    }

    @Test
    public void pictureCardsShouldPrintRankWithLetterNotNumber() {
        Assert.assertEquals("Hearts A", new Card(Suit.Hearts, 1).toString());
        Assert.assertEquals("Hearts J", new Card(Suit.Hearts, 11).toString());
        Assert.assertEquals("Hearts Q", new Card(Suit.Hearts, 12).toString());
        Assert.assertEquals("Hearts K", new Card(Suit.Hearts, 13).toString());
    }

    @Test
    public void given10PointsWhenDealtAceThenItShouldCountAs11() {
        Player player = new Player();
        player.hit(new Card(Suit.Hearts, 10));
        player.hit(new Card(Suit.Hearts, 1));
        Assert.assertEquals(21, player.getTotalPoints());
    }

    @Test
    public void given11PointsWhenDealtAceThenItShouldCountAs1() {
        Player player = new Player();
        player.hit(new Card(Suit.Hearts, 7));
        player.hit(new Card(Suit.Hearts, 4));
        player.hit(new Card(Suit.Hearts, 1));
        Assert.assertEquals(12, player.getTotalPoints());
    }
}