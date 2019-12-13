package main;
import  java.util.ArrayList;
import  java.util.Arrays;
import java.util.List;
public class Game {
    public Game[] ListofPlayers;
    public Player[] CardsInHand;
    public MemorizingDeck [] memorizingDecks;
    Playround playround;
    Player player = new Player();


    public void gatherPlayers(){

    }
    public void playNewGame() {

    }
    public boolean CheckInput(int i){
        return playround.CheckInput(i);
    }
    public void playCard(int i){
        player.playCard(i);

    }
    public boolean takeCard(int i){

        return player.takeCard(i);

    }
    public boolean sayUNO(){
        return player.sayUNO();
    }
}
