public class Game {
    private Die myDie = new Die();
    private Players players = new Players();
    private Gameboard gameboard = new Gameboard();

    public int setSize(int i) {
        this.gameboard.setSize(i);
        return 1;
    }

    public void addPlayer(String name) {
        Player player = new Player();
        player.setName(name);
        players.add(player);
    }

    public void nextTurn() {

        while(!gameboard.isGameOver()) {
            int randInt = myDie.rollDie();
            Player nextPlayer = players.remove();
            int newPositon = gameboard.move(nextPlayer.getPosition(), randInt);
            nextPlayer.setPosition(newPositon);
            players.add(nextPlayer);
        }
    }
}
