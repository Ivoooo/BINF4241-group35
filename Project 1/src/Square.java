public class Square {

    int type;
    boolean occupied;

    public void newSquare(int i){
        type=3;
        occupied = false;
    }



    public int squareType(int square){
        return type;

    public void setOccupied(int square){
        occupied = true;
        return;

    }

    public void sendHome(Player p){
        if (occupied == true) {
          //  p.setPosition(1);
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



