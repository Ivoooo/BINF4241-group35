import java.util.Scanner;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Game ourGame = new Game();

        System.out.println(" Choose your game size: ");
        int size = keyboard.nextInt();
        ourGame.setSize(size);

        System.out.println("How many players want to play? (Between 2 and 4");
        int numPlayers = keyboard.nextInt();
        if (numPlayers < 2 || numPlayers > 4) {
            System.out.println("Wrong number of players.");
        }

        for (int i = 1 ; i <= numPlayers;++i){
            System.out.println("How should your new player be named?");
            //get String
            ourGame.addPlayer("Fred");
        }
    }
}