
public class Game {
    Chessboard ourChessBoard = new Chessboard();

  /*  public void addPlayer(String name,String color){

        Player player = new Player(name,color) ;
    }
*/

    public void nextRound(String move){
        Figur currFigure = new Figur();
        int x = 0;
        int y = 0 ;
        Coordinates end = new Coordinates(x,y);
        //Resolve String:
        //set currFigure type: and color
        //Pass Information: Figur and Position: end to move

        ourChessBoard.move(type,color,x,y, capture);

    }


}
