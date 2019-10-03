

public class Square {
    int type = 3;
    boolean occupied = false;
    Square nextSquare = new Square();

    public void setOccupied(int square){
        occupied = true;
        return;
    }

    public void sendHome(int square) {
        if (occupied == true) {
            // setPlayer(1);
        }
        return;
    }

/*    public int makeSnake(int square,int gamesize){
        int length = getRandomNumberInRange(-1,-6);
        type = -1;
        return length;
    }

    public int makeLadder(int square, int gamesize){
        int length = getRandomNumberInRange(1,6);
        type = 1;
        return length;
    }

        private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return (int)(Math.random() * ((max - min) + 1)) + min;
    }
 }

 */

    public void setStart(int square) {
        type = 0;
        return;
    }

    public void setFinish(int square) {
        type = 2;
        return;
    }

    public int squareType(int square) {
        return type;
    }

}



