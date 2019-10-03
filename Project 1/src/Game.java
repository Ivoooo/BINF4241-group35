public class Game {
    private int size;
    private int currentPlayer = 0;
    private Die myDie = new Die();
    //private Squares[] squareArray;
    //private Player[] playerArray; = new Player[amount];

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
}
