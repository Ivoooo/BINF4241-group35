import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        //get size
        System.out.println(" Choose your game size: (more than 5)");
        int size = keyboard.nextInt();
        if (size <= 5) {
            System.out.println("Too few tiles.");
            size = 15;
            System.out.println("You now play with 15 tiles instead!");
        }
        Game ourGame = new Game(size);

        //get players
        System.out.println("How many players want to play? (Between 2 and 4)");
        int numPlayers = keyboard.nextInt();
        if (numPlayers < 2 || numPlayers > 4) {
            System.out.println("Wrong number of players.");
            numPlayers = 2;
            System.out.println("You now play with 2 players instead!");
        }

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