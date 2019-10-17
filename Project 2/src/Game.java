public class Game {
    Chessboard ourChessBoard = new Chessboard();

    public Game() {
        ourChessBoard.boardoutput();
    }

  /*  public void addPlayer(String name,String color){

        Player player = new Player(name,color) ;
    }
*/


    public boolean nextRound(String move){

        //Resolve String:
        //set currFigure type: and color
        //Pass Information: Figur and Position: end to move

        int x = inputParser.returnX(move);
        int y = inputParser.returnY(move);
        attributes.types type = inputParser.returnType(move);
        boolean capture = inputParser.capture(move);
        System.out.println(x);
        System.out.println(y);
        System.out.println(type);
        System.out.println(capture);
        boolean success = ourChessBoard.move(type, attributes.colors.white,x,y, capture);

        if (success) ourChessBoard.boardoutput();

        return success;
    }


}
