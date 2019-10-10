
public class Game {


  /*  public void addPlayer(String name,String color){

        Player player = new Player(name,color) ;
    }
*/

    public void nextRound(String move){
        Figur currFigure = new Figur();
        Coordinates end = new Coordinates();
        //Resolve String:
        //set currFigure type: and color
        //Pass Information: Figur and Position: end to move
        Move.move(figur,end);


    }


    public void tryMove(String move){
       // Chessboard.checkMove(move);

    }
    public boolean checkMate(){
         // check both Kings ?
        //Game Over ; Winner is:
    }

}
