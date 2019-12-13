package test;

import main.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UnoTests {
    /**
     * @author Marco Heiniger
     * @Version 1.0
     * First I'm testing that the right amount of players are playing.
     */
    @Test
    public void Playerlistcorrect() {
        Game game = new Game();
        game.gatherPlayers();
        int b = 0;
        for (int i = 0; i < game.ListofPlayers.length; i++)
            b += 1;

        Assert.assertFalse(b < 2 | b > 10);
    }

    /**
     *Next I want to make sure that the players got 7 cards in the beginning of a game
     */
    @Test
    public void PlayersgotcorrectCardsnumber() {
        Game game = new Game();
        game.playNewGame();
        Assert.assertEquals(game.CardsInHand.length, 7);
    }
    /**
     * Next thing is that i want to test if the CheckInput method works.
     * (0 stands for not playing a card and to pass to the next player).
     * Each number stand for a specific card
     */

    @Test
    public void Checkinputmethod(){
        Game game = new Game();
        Playround playround = new Playround();
        game.CardsInHand = new Player[7];
        for (int i = 0; i < 7; ++i) {
            game.CardsInHand[i] = new Player();
        }
        Assert.assertTrue(game.CheckInput(1));
        Assert.assertTrue(game.CheckInput(4));
        Assert.assertFalse(game.CheckInput(8));
        Assert.assertTrue(game.CheckInput(0));
    }

    /**
     * Next thing to test if a card is valid and the card has been played that the player owns a card less and the card goes to
     * the discard pile.
     * (The player plays for the first time a card because of that he should have 6 cards after he played the card)
     */
    @Test
    public void checkplaycard(){
        CircularDeck deck = new CircularDeck();
        Game game = new Game();
        game.playNewGame();
        game.CheckInput(3);
        game.playCard(3);
        Assert.assertEquals(CircularDeck.lastplayedcard, 3);
        Assert.assertEquals(game.CardsInHand.length, 6);

    }

    /**
     * Next thing to test is when the player can't play a card that he takes one from the memorizing Deck
     */
    @Test
    public void checktakecard(){
        Game game = new Game();
        game.playNewGame();
        int b = game.CardsInHand.length;
        game.CheckInput(0);
        game.takeCard();
        Assert.assertTrue(game.CardsInHand.length > b);
    }

    /**
     * The next method I want to test is the sayUNO method. This method is called when the player only got one card left in his hand
     */
    @Test
    public void checksayUNO(){
        Game game = new Game();
        game.playNewGame();
        game.CardsInHand = new Player[7];
        for (int i = 0; i < 3; ++i) {
            game.CardsInHand[i] = new Player();
        }
        Assert.assertFalse(game.sayUNO(),"You have more than one card take 2 new cards");

    }




}
