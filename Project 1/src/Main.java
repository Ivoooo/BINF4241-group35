import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        //get size
        System.out.println(" Choose your game size: (more than 5)");
        int size;
        try {
            size = Integer.parseInt(keyboard.next());
        }
        catch(NumberFormatException e)
        {
            System.out.println("Since you failed to give a proper number you'll now play with 15 tiles.");
            size = 15;
        }
        if (size <= 5) {
            System.out.println("Too few tiles. You now play with 15 tiles instead!");
            size = 15;
        }
        Game ourGame = new Game(size);

        //get players
        System.out.println("How many players want to play? (Between 2 and 4)");
        int numPlayers;
        try {
            numPlayers = Integer.parseInt(keyboard.next());
        }
        catch(NumberFormatException e)
        {
            System.out.println("Since you failed to give a proper number you'll now play with 3 players.");
            numPlayers = 3;
        }
        if (numPlayers < 2 || numPlayers > 4) {
            System.out.println("Wrong number of players. You now play with 2 players instead!");
            numPlayers = 2;
        }

        //get player's names
        String name;
        for (int i=1 ; i <= numPlayers; ++i){
            System.out.println("How should your new player be named?");
            name = keyboard.next();
            ourGame.addPlayer(name);
        }

        //play game
        System.out.println("Initial state:" + ourGame.getGameBoard());
        while (!ourGame.isFinished()) {
            ourGame.nextTurn();
        }
    }
}