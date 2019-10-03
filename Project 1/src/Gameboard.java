public class Gameboard {
    Square GameboardArray[];

    public void setSize(int j) {
        GameboardArray = new Square[j];
        for (int i=0;i<= j; i++){
            GameboardArray[i].newSquare();
        }
    }
}
