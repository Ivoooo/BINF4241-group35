package main;

public class Player {
    CircularDeck deck = new CircularDeck();
    int b = CircularDeck.lastplayedcard;
    public void playCard(int i){
        b = i;
    }
    public boolean takeCard(int i){
            return true;
    }
    public boolean sayUNO(){
        return true;
    }
}
