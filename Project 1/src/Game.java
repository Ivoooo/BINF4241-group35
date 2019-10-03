public class Game {
    private Die myDie = new Die();
    private Players players = new Players();
    private Gameboard gameboard = new Gameboard();

    public int setSize(int i) {
        this.gameboard.setSize(i);
        //SquareArray[0].setStart;
        //SquareArray[SquareArray.length() - 1].setEnd;
        // ... define Ladders and Snackes

        return 1;
    }

    public void movePlayer(int i) {
        //remove player from Players
        Player Jack = new Player(); //sött nöd si
        //Jack.moveFwd(i);
    }

    public void addPlayer(String name) {
        Player player = new Player();
        player.setName(name);
        players.add(player);
    }

    public Player removePlayer() {
        return players.remove();
    }

    public void nextTurn() {
        int randInt = myDie.rollDie();
        Player nextPlayer = removePlayer();

    }
}
