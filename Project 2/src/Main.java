import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        // Get Player Name
        Game ourGame = new Game();
        String name;
        for (int i= 1; i<3;i++) {
            System.out.println(" Please enter the name of Player "+i+": ");
            name = keyboard.next();
            ourGame.addPlayer();
        }
        while (true) {
            System.out.println("Please enter your next move:  ");
            String move = keyboard.next();
            ourGame.tryMove(move);
            ourGame.checkMate();

            // get String of next move
            //
        }
}