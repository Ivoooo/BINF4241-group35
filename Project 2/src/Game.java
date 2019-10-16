
public class Game {
    Chessboard ourChessBoard = new Chessboard();

  /*  public void addPlayer(String name,String color){

        Player player = new Player(name,color) ;
    }
*/


    public void nextRound(String move){

        //Resolve String:
        //set currFigure type: and color
        //Pass Information: Figur and Position: end to move

        int x = readInput.returnX(move);
        int y = readInput.returnY(move);
        Figur.attributes.types = readInput.returnType(move);
        boolean capture = readInput.capture(move);

        ourChessBoard.move(Figur.attributes.types,color,x,y, capture);

    }


}
