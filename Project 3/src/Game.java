public class Game {
    private Observer observer = new Chessboard();
    private Player p1 = null;
    private Player p2 = null;
    private Player currentPlayer;
    private ScoreboardSingleton scoreboardSingleton = ScoreboardSingleton.getInstance();

    public Game() {
        observer.boardOutput();
    }



    public void addPlayer(String name){
        if(p1 == null) {
            p1 = new Player(name, "white");
            currentPlayer = p1;
        }
        else if(p2 == null) {
            p2 = new Player(name, "black");
        }
        else {
            System.out.println("Players are already defined.");
        }
    }

    private void swapCurrentPlayer() {
        if (currentPlayer.getCol() == p1.getCol()) currentPlayer = p2;
        else currentPlayer = p1;
    }

    //returns true if game is over
    public boolean isGameOver(){
        return(observer.isGameOver(currentPlayer.getCol()));
    }


    public boolean nextRound(String move){
        if (isGameOver()) {
            System.out.println("Sorry the game is over");
            return false;
        }
        if(!validInput(move)) return false;
        parsedInput input = new parsedInput(move);
        if (!input.possibleInput()) return false;

        boolean success = observer.tryMove(input, currentPlayer.getCol());
        if (success) {
            observer.boardOutput();
            scoreboardSingleton.printScore();

            swapCurrentPlayer();
        }

        return success;
    }

    private static Boolean validInput(String input) {
        boolean state1 = false;
        boolean state2 = false;
        boolean state3 = false;


        if (input.length() < 1 || input.length() > 5 ) return false;
        if (input.equals("x") || input.equals("X") || input.equals("0-0") || input.equals("0-0-0")) {return true;}
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
        if(input.length() == 5){
           if( input.contains(":")==true){
               for (int j = 0; j < input.length(); j++) {
                   ch = input.charAt(j);
                   if (Character.isLowerCase(ch)) {
                       state2 = true;
                   }
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