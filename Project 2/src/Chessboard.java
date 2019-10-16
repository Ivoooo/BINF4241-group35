public class Chessboard {
    private Figur[][] board = new Figur[8][8];
    private Figur[] grave = new Figur[32];

    public Chessboard() {
        String col = "white";
        for(int i = 0, j; i < 16; ++i) {
            if (i > 8) col = "black";
            j = i % 8;
            if (j == 0 || j == 7) board[0][j] = new Rook(col);
            else if (j == 1 || j == 6) board[0][j] = new Knight(col);
            else if (j == 2 || j == 5) board[0][j] = new Bishop(col);
            else if (j == 3) board[0][j] = new Queen(col);
            else board[0][j] = new King(col);
        }

        col = "white";
        for(int i = 0; i < 8; ++i) {
            board[1][i] = new Pawn(col);
        }

        col = "black";
        for(int i = 0; i < 8; ++i) {
            board[7][i] = new Pawn(col);
        }
    }

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
