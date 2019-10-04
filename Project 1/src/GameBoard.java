public class GameBoard {
    private Square[] gameBoard;

    public GameBoard (int size) {
        this.gameBoard = new Square[size];
        for (int i = 0; i < size; ++i) {
            this.gameBoard[i] = new Square();
        }
        this.gameBoard[0].setStart();
        this.gameBoard[gameBoard.length - 1].setFinish();

        //this.gameB
        //TODO set Ladders & Snakes
        int numsnake = Randomizer.generate(-1, -(size % 5));
        int numladder = Randomizer.generate(1, (size % 5));
        int eventS = 2 ;//Randomizer.generate(2,gameBoard.length-2);
        int eventL= 4 ;//Randomizer.generate(2,gameBoard.length-1);

        for (int j = 0; j<2; j++) {
            this.gameBoard[eventS].makeShortcut(eventS + numsnake, "SNAKE");
            this.gameBoard[eventL].makeShortcut(eventL + numladder, "LADDER");
        }
    }

    public boolean isGameOver() {
        return gameBoard[gameBoard.length - 1].isOccupied();
    }

    private int getNextPosition(int current, int step) {
        if (current + step < gameBoard.length) {
            return current + step;
        }
        return current + (current + step - gameBoard.length);
    }

    public void place(String name) {
        gameBoard[0].tryMove(name);
    }

    public Player move(Player current, int step){
        gameBoard[current.getPosition()].leave(current.getName());
        int newPosition = getNextPosition(current.getPosition(), step);

        Boolean unoccupied = gameBoard[newPosition].tryMove(current.getName());
        if (!unoccupied) {
            newPosition = gameBoard[newPosition].getDestination();
            gameBoard[newPosition].tryMove(current.getName());
        }

        current.setPosition(newPosition);
        return current;
    }

    public String repr() {
        String x = "";
        for (int i = 0; i < gameBoard.length; ++i) {
            x += gameBoard[i].repr(i);
        }
        return x;
    }
}
