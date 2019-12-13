package main;

public class Game {
    private Die myDie = new Die();
    private Players players = new Players();
    private GameBoard gameboard;

    public Game(int size) {
        if(size < 5) size = 5;
        this.gameboard = new GameBoard(size);
    }

    public void addPlayer(String name) {
        Player player = new Player(name);
        gameboard.place(name);
        players.add(player);
    }

    public boolean isFinished() {
        return gameboard.isGameOver();
    }

    public String getGameBoard() {
        return gameboard.repr();
    }

    public void nextTurn() {
        if(!isFinished()) {
            int roll = myDie.rollDie();
            Player currPlayer = players.remove();
            currPlayer = gameboard.move(currPlayer, roll);

            System.out.println(currPlayer.getName() + " rolls " + roll + ": " + this.getGameBoard());

            players.add(currPlayer);
        }
    }
}
