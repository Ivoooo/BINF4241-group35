public class Game {
    private Chessboard ourChessBoard = new Chessboard();

    public Game() {
        ourChessBoard.boardOutput();
    }

  /*  public void addPlayer(String name,String color){

        Player player = new Player(name,color) ;
    }
*/


    public boolean nextRound(String move){

        //Resolve String:
        //set currFigure type: and color
        //Pass Information: Figure and Position: end to move

        int x = inputParser.returnX(move);
        int y = inputParser.returnY(move);
        Attributes.types type = inputParser.returnType(move);
        boolean capture = inputParser.capture(move);
        System.out.println(x);
        System.out.println(y);
        System.out.println(type);
        System.out.println(capture);
        boolean success = ourChessBoard.move(type, Attributes.colors.white,x,y, capture);

        if (success) ourChessBoard.boardOutput();

        return success;
    }


}
