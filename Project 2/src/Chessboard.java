public class Chessboard {
    private Figur[][] board = new Figur[8][8];
    private Figur[] grave = new Figur[32];

    public Chessboard() {
        for (int i = 0; i < 8; ++i) {
            for ( int j = 0; j < 8; ++j) {
                board[i][j] = null;
            }
        }
        
        String col = "white";
        int x = 0;
        for(int i = 0, j; i < 16; ++i) {
            if (i >= 8) {
                col = "black";
                x = 7;
            }
            j = i % 8;
            if (j == 0 || j == 7) board[x][j] = new Rook(col);
            else if (j == 1 || j == 6) board[x][j] = new Knight(col);
            else if (j == 2 || j == 5) board[x][j] = new Bishop(col);
            else if (j == 3) board[x][j] = new Queen(col);
            else board[x][j] = new King(col);
        }

        col = "white";
        x = 1;
        for(int i = 0; i < 16; ++i) {
            if (i >= 8) {
                col = "black";
                x = 6;
            }
            board[x][i % 8] = new Pawn(col);
        }
    }

    private Coordinates findFigure(attributes.types type, attributes.colors col) {
        for(int i=0; i < 8; ++i) {
            for(int j=0; j < 8; ++j) {
                if (board[i][j] != null) {
                    if (board[i][j].getType() == type && board[i][j].getCol() == col) {
                        return new Coordinates(i, j);
                    }
                }
            }
        }
        return null;
    }

    boolean gameOver() {
        return false;
    }

    boolean isCheck(String color) {
        return false;
    }

    boolean move(attributes.types type, attributes.colors col, int x, int y, boolean capture) {
        Coordinates coord = findFigure(type, col);
        if (coord == null) return false;
        if (capture && board[x][y] == null || !capture && board[x][y] != null) return false; //todo check if killing the same color

        return board[coord.getX()][coord.getY()].checkmove(coord.getX(), coord.getY(), x, y);
    }

    public void boardoutput(){
        String x;
        for(int i=7; i >= 0; --i){
            x = "";
            for(int j=0; j < 8; ++j){
                if (board[i][j] == null) x += "[]";
                else x += board[i][j].figureOutput();
            }
            System.out.println(x);
        }
    }
}
