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
        parsedInput input = new parsedInput(move);

        /*
        System.out.println(x);
        System.out.println(y);
        System.out.println(type);
        System.out.println(getCapture);
        */
        boolean success = ourChessBoard.move(input, Attributes.colors.white);

        if (success) ourChessBoard.boardOutput();

        return success;
    }


}
