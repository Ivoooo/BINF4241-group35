package main;

public class GameBoard {
    private Square[] gameBoard;

    public GameBoard (int size) {
        if(size < 5) size = 5;

        this.gameBoard = new Square[size];
        for (int i = 0; i < size; ++i) {
            this.gameBoard[i] = new Square();
        }
        this.gameBoard[0].setStart();
        this.gameBoard[gameBoard.length - 1].setFinish();

        int numsnake =0;
        int numladder=0;
        int eventS=0;
        int eventL=0;

        while ((eventL + numsnake) < 1 | eventL +numladder > (gameBoard.length-1) ){
            numsnake = Randomizer.generate(-1, -(size-size/2));
            numladder = Randomizer.generate(2, (size-size/2));
            eventS = Randomizer.generate(3,gameBoard.length-2);
            eventL= Randomizer.generate(2,gameBoard.length-1);
        }

        this.gameBoard[eventL].makeShortcut(eventL + numladder, "LADDER");
        //so they can't loop to each other
        if (eventS != eventL + numladder || eventL != eventS + numsnake) {
            this.gameBoard[eventS].makeShortcut(eventS + numsnake, "SNAKE");
        }
    }

    public boolean isGameOver() {
        return gameBoard[gameBoard.length - 1].isOccupied();
    }

    private int getNextPosition(int current, int step) {
        if (current + step < gameBoard.length) {
            return current + step;
        }
        return 2*gameBoard.length - (current + step + 2);
    }

    public void place(String name) {
        gameBoard[0].tryMove(name);
    }

    public Player move(Player current, int step){
        if(step <= 0) return null;

        //leave position
        gameBoard[current.getPosition()].leave(current.getName());

        //find new place to go
        int newPosition = getNextPosition(current.getPosition(), step);
        while (!gameBoard[newPosition].tryMove(current.getName())) {
            newPosition = gameBoard[newPosition].getDestination();
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
