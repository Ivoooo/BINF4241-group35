import java.util.Scanner;

public class Game {
    public boolean gameOver = false;
    Scanner keyboard = new Scanner(System.in);
    private int round = 0;
    public void addPlayer(String name,String color){
        Player Player1 = new Player(name,color) ;
    }

    public void nextRound(){
        //Check whose turn it is
        if (round == 0){
            round =1;
           // current Player = Player1
        }
        System.out.println(currentPlayer+" enter your next move:  ");
        String move = keyboard.next();

        ourGame.tryMove(move);
        ourGame.checkMate();


    }

    public void tryMove(String move){
       // Chessboard.checkMove(move);

    }
    public boolean checkMate(){
         // check both Kings ?
        //Game Over ; Winner is:
    }

}
