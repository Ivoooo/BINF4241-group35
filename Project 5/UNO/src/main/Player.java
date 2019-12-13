package main;

public class Player {
    CircularDeck deck = new CircularDeck();
    int b = CircularDeck.lastplayedcard;
    public void playCard(int i){
        b = i;
    }
    public void takeCard(){

    }
    public boolean sayUNO(){
        return true;
    }
}
