public class GameBoard {
    private Square[] gameBoard;

    public GameBoard (int size) {
        this.gameBoard = new Square[size];
        for (int i = 0; i < size; ++i) {
            this.gameBoard[i] = new Square();
        }
        this.gameBoard[0].setStart();
        this.gameBoard[gameBoard.length - 1].setFinish();

        //TODO set Ladders & Snackes
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
