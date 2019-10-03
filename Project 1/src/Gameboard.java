public class Gameboard {
    Square GameboardArray[];

    public void setSize(int j) {
        GameboardArray = new Square[j];
        for (int i = 0; i <= j; i++) {
            GameboardArray[i].newSquare();
        }
    }

    public boolean isGameOver() {
        if (GameboardArray[GameboardArray.length - 1].isOccupied())
        {
            return true;
        }
            return false;
    }
    public void move(int current, int steps){
        if(current = 0){
            GameboardArray[0] += steps;
        }
        else{
            GameboardArray[current] += steps;
        }
        //current wird unoccuptied
        //evaluete where to go next
        //next occupied setzte
        //return new position
        // falls nur noch 1 feld und 3 gewürfelt 2 zürück
    }
}
