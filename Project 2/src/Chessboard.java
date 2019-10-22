import java.util.Scanner;

public class Chessboard {
    private Figure[][] board = new Figure[8][8];
    private Figure[] grave = new Figure[32]; //todo grave
    private boolean blackCastlePossible = true;
    private boolean whiteCastlePossible = false;

    public Chessboard() {
        for (int i = 0; i < 8; ++i) {
            for ( int j = 0; j < 8; ++j) {
                board[j][i] = null;
            }
        }
        
        Attributes.colors col = Attributes.colors.white;
        int x = 0;
        for(int i = 0, j; i < 16; ++i) {
            if (i >= 8) {
                col = Attributes.colors.black;
                x = 7;
            }
            j = i % 8;
            if (j == 0 || j == 7) board[j][x] = new Rook(col);
            else if (j == 1 || j == 6) board[j][x] = new Knight(col);
            else if (j == 2 || j == 5) board[j][x] = new Bishop(col);
            else if (j == 3) board[j][x] = new Queen(col);
            else board[j][x] = new King(col);
        }

        col = Attributes.colors.white;
        x = 1;
        for(int i = 0; i < 16; ++i) {
            if (i >= 8) {
                col = Attributes.colors.black;
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

    private Coordinates getKing(Attributes.colors col) {
        Coordinates[] tmp = findFigure(Attributes.types.king, col);
        return tmp[0];
    }

    //returns true if game over, false if not.
    private boolean isGameOver(Attributes.colors col) {
        //if not check
        Coordinates c = getKing(col);
        if (!isCheck(c, col)) return false;

        //iterate through possibles moves for the King:
        for(int i = -1; i <= 1; ++i) {
            for(int j= -1; j <= 1; ++j) {
                if (i == 0 && j == 0) continue;
                if(0 <= c.getX() + i && c.getX() + i < 8 && 0 <= c.getY() + j && c.getY() + j < 8) {
                    //if occupied and by the same color:
                    if (board[c.getX()+i][c.getY()+j] != null) {
                        if(board[c.getX()+i][c.getY()+j].getCol() == col) {
                            continue;
                        }
                    }

                    //if possible move is not check:
                    Coordinates tmp = new Coordinates(c.getX()+i, c.getY()+j);
                    if(!isCheck(tmp, col)) return false;
                }
            }
        }
        return true;
    }

    private boolean isCheck(Coordinates coord, Attributes.colors col) {
        for(int i=0; i < 8; ++i) {
            for(int j=0; j < 8; ++j) {
                if (board[i][j] != null) {
                    if (board[i][j].getCol() != col && board[i][j].checkmove(i, j, coord.getX(), coord.getY())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void checkPromotion(Coordinates c, Attributes.colors col) {
        if(board[c.getX()][c.getY()].getType() == Attributes.types.pawn) {
            if (c.getY() == 7 && col == Attributes.colors.white ||
                c.getY() == 0 && col == Attributes.colors.black) {
                promotion(c, col);
            }
        }
    }

    private void promotion(Coordinates c, Attributes.colors col) {
        Scanner keyboard = new Scanner(System.in);

        String a = "";
        while(! (a.equals("R") || a.equals("N") || a.equals("B") || a.equals("Q"))) {
            System.out.println("You managed to get a Pawn to the other side! What role do you want him to be? R / N / B / Q");
            a = keyboard.next();
        }

        switch (a) {
            case "R": board[c.getX()][c.getY()] = new Rook(col);
            case "N": board[c.getX()][c.getY()] = new Knight(col);
            case "B": board[c.getX()][c.getY()] = new Bishop(col);
            default: board[c.getX()][c.getY()] = new Queen(col);
        }
    }

    private boolean checkCastle(parsedInput i, Attributes.colors c) {
        //todo complete for both colors and both sides (king and queen side)
        if (i.getType() != Attributes.types.king) return false;
        if (c == Attributes.colors.white && !whiteCastlePossible ||
            c == Attributes.colors.black && !blackCastlePossible) return false;

        return false;
    }

    boolean move(parsedInput input, Attributes.colors col) {
        //todo you can't move past units with queen/rook/bishop
        //check if getCapture was done properly.
        if(board[input.getX()][input.getY()] != null) {
            if (!input.getCapture() || board[input.getX()][input.getY()].getCol() == col) return false;
        }
        else {
            if(input.getCapture()) return false;
        }

        //find all figures that are still in the game
        Coordinates[] coords = findFigure(input.getType(), col);
        if (coords[0] == null) return false;

        Coordinates tmp;
        for(int i = 0; i < coords.length && coords[i] != null; ++i) {
            if (board[coords[i].getX()][coords[i].getY()].checkmove(coords[i].getX(), coords[i].getY(), input.getX(), input.getY())) {
                //todo when moving possibly disable Castle Booleans
                board[input.getX()][input.getY()] = board[coords[i].getX()][coords[i].getY()];
                board[coords[i].getX()][coords[i].getY()] = null;
                tmp = new Coordinates(input.getX(), input.getY());
                checkPromotion(tmp, col);
                return true;
            }
        }
        return checkCastle(input, col);
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