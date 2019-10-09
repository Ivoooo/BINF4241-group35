import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Game ourGame = new Game();
        String name;
        String color;

        // Get Player Names: initialize Players
        for (int i= 1; i<3;i++) {
            System.out.println(" Please enter the name of Player "+i+": ");
            name = keyboard.next();
            if (i==1) color = "white";
            else color ="black";
            ourGame.addPlayer(name,color);
        }


        //Play Game
        while (true) {
            Game.nextRound();
        }


            // get String of next move
            //
        }
}