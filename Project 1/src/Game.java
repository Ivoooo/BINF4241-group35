public class Game {
    private int size;
    private Die myDie = new Die();
    private Players players = new Players();

    public int setSize(int i) {
        this.size = i;
        //squareArray = new Square[size];
        //SquareArray[0].setStart;
        //SquareArray[SquareArray.length() - 1].setEnd;
        // ... define Ladders and Snackes

        return this.size;
    }

    public int getSize() {
        return this.size;
    }

    public String roll() {
        int randInt = myDie.rollDie();
        //move
        //prevPlayer = currentPlayer;
        //if game not over:
        return "prevPlayer.name rolled a " + randInt;
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

    public String removePlayer() {
        Player x = players.remove();
        return x.getName();
    }
}
