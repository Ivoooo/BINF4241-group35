public class Chessboard {
    int[][] board = new int[8][8];
    int[] grave = new int[32];

    boolean gameOver() {
        return false;
    }

    boolean isCheck(String color) {
        return false;
    }

    boolean move(int x, int y, int newX, int newY) {
        return true;
    }
}
