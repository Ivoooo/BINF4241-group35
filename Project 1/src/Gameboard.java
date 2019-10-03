public class Gameboard {
    Square GameboardArray[];
    Square square = new Square();

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
    public int move(int current, int step){
        //square ist oben benannt worden
        square.setOccupiedfalse(current);
        int newposition = current + step;
        square.setOccupiedtrue(newposition);
        if(newposition > GameboardArray.length){
            newposition = GameboardArray.length - (newposition-GameboardArray.length);
            return newposition;
        }
        else{
        return newposition;
        }
    }
}
