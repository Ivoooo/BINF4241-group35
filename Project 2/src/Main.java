import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String name;
        String color;
        String move;

        // Get Player Names: initialize Players

        System.out.println(" Please enter the name of Player1: ");
        name = keyboard.next();
        Player p1 = new Player(name,"white");
        System.out.println(" Please enter the name of Player2: ");
        name = keyboard.next();
        Player p2 = new Player(name,"black");


        Game ourGame = new Game();
        Player currentPlayer = p1;
        String command;
        boolean success;

        while(true) {
            System.out.println(currentPlayer.getName() + " Next command please: (0 to stop)");
            command = keyboard.next();
            if (command.equals("0")) break;
            else {
                success = ourGame.nextRound(command, currentPlayer);
                if (!success) System.out.println("Wrong command");
            }
            if(ourGame.GameOver(currentPlayer)==true){ System.out.println("Checkmate!"); break;}

                if (currentPlayer == p1 && success){
                currentPlayer = p2;
            }
            else if(currentPlayer == p2 && success){currentPlayer = p1;}

        }
    }
}

//TODO Nc3 works as first move for Black Knight but shoudn't...
