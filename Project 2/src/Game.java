public class Game {
    private Chessboard ourChessBoard = new Chessboard();

    public Game() {
        ourChessBoard.boardOutput();
    }

  /*  public void addPlayer(String name,String color){

        Player player = new Player(name,color) ;
    }
*/


  //todo change color , abort when game is over


    public boolean nextRound(String move){
        if(validInput(move)== false) return false;
            parsedInput input = new parsedInput(move);
            boolean success = ourChessBoard.tryMove(input, Attributes.colors.white);

            if (success) ourChessBoard.boardOutput();

            return success;


    }

    private static Boolean validInput(String input) {
        boolean state1 = false;
        boolean state2 = false;
        boolean state3 = false;

        if (input.length() < 1 | input.length() > 5) return false;
        if (input == "x" | input == "X" | input == "0-0" | input == "0-0-0") { return true;}
        char ch;
        for (int i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                state1 = true;
            }
        }
        if (input.length() == 2) {
            for (int j = 0; j < input.length(); j++) {
                ch = input.charAt(j);
                if (Character.isLowerCase(ch)) {
                    state2 = true;
                }
               }
            if (state1 == true && state2 == true) return true;
            }
        else {
            for (int i = 0; i < input.length(); i++) {
                ch = input.charAt(i);
                    if (Character.isUpperCase(ch)) {
                        state2 = true;
                    }
                    if (Character.isLowerCase(ch)) {
                        state3 = true;
                    }
                    if (state1 == true && state2 == true && state3 == true) return true;
                }

            }

        return false;
    }
}