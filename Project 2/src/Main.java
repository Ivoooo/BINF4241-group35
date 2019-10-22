import java.util.Scanner;

public class Main {
    enum Players{PLAYER1, PLAYER2};

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String name;
        String color;
        String move;
        Players player = Players.PLAYER1;
        Players player2 = Players.PLAYER2;
        // Get Player Names: initialize Players
        for (int i= 1; i<3;i++) {
            System.out.println(" Please enter the name of Player "+i+": ");
            name = keyboard.next();
            if (i==1){
                Player p1 = new Player(name,"white");
            }
            else {
                Player p2 = new Player(name,"black") ;
            }

        }


        Game ourGame = new Game();

        String command;
        boolean success;
        while(true) {
            System.out.println("Next command please: (0 to stop)");
            command = keyboard.next();
            if (command.equals("0")) break;
            else {
                success = ourGame.nextRound(command);
                if (!success) System.out.println("Wrong command");
            }
        }
    }
}