public class Chessboard {
    private Figure[][] board = new Figure[8][8];
    private Figure[] grave = new Figure[32];

    public Chessboard() {
        for (int i = 0; i < 8; ++i) {
            for ( int j = 0; j < 8; ++j) {
                board[j][i] = null;
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
            else board[x][j] = new King(col);
            if (j == 0 || j == 7) board[j][x] = new Rook(col);
            else if (j == 1 || j == 6) board[j][x] = new Knight(col);
            else if (j == 2 || j == 5) board[j][x] = new Bishop(col);
            else if (j == 3) board[j][x] = new Queen(col);
            else board[j][x] = new King(col);
        }

        col = "white";
        x = 1;
        for(int i = 0; i < 16; ++i) {
            if (i >= 8) {
                col = "black";
                x = 6;
            }
            board[i % 8][x] = new Pawn(col);
        }
    }

    private Coordinates[] findFigure(Attributes.types type, Attributes.colors col) {
        Coordinates[] c = new Coordinates[8];
        for(int i=0; i < 8; ++i) {
            c[i] = null;
        }

        int amount = 0;
        for(int i=0; i < 8; ++i) {
            for(int j=0; j < 8; ++j) {
                if (board[i][j] != null) {
                    if (board[i][j].getType() == type && board[i][j].getCol() == col) {
                        c[amount] =  new Coordinates(i, j);
                        ++amount;
                    }
                }
            }
        }
        return c;
    }

    boolean gameOver() {
        return false;
    }

    boolean isCheck(String color) {
        return false;
    }

    //todo Qe4 works but many don't.
    boolean move(parsedInput input, Attributes.colors col) {
        if (input.getCapture() && board[input.getX()][input.getY()] == null ||
                !input.getCapture() && board[input.getX()][input.getY()] != null) return false; //todo check if killing the same color

        Coordinates[] coords = findFigure(input.getType(), col);
        if (coords[0] == null) return false;

        for(int i = 0; i < coords.length && coords[i] != null; ++i) {
            if (board[coords[i].getX()][coords[i].getY()].checkmove(coords[i].getX(), coords[i].getY(),
                    input.getX(), input.getY())) {
                board[input.getX()][input.getY()] = board[coords[i].getX()][coords[i].getY()];
                board[coords[i].getX()][coords[i].getY()] = null;
                return true;
            }
        }
        return false;
    }

    public void boardOutput(){
        String x;
        for(int i=7; i >= 0; --i){
            x = "";
            for(int j=0; j < 8; ++j){
                if (board[j][i] == null) x += "[]";
                else x += board[j][i].figureOutput();
            }
            System.out.println(x);
        }
    }
}
