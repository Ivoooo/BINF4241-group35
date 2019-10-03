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

}
