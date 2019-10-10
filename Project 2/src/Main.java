import java.util.Scanner;

public class Main {
    enum Players{PLAYER1, PLAYER2};

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Game ourGame = new Game();
        String name;
        String color;
        String move;
        Players player = Players.PLAYER1;

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

        //Play Game
        while (true) {
            if(player == Players.PLAYER1) {
                System.out.println("Player 1,Whats your move? ");  // get name from player to replace player 1 with name
                move = keyboard.next();
                ourGame.nextRound(move);
                player = Players.PLAYER2;
            }else{
                System.out.println("Player 2,Whats your move? ");  // get name from player to replace player 2 with name
                move = keyboard.next();
                ourGame.nextRound(move);
                player = Players.PLAYER1;
            }

        }


            // get String of next move
            //
        }
}