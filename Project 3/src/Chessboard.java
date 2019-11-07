import java.util.Scanner;
import static java.lang.Math.abs;

public class Chessboard implements Observer {
    private Figure[][] board = new Figure[8][8];
    private boolean blackQsCastlePossible = true;
    private boolean whiteQsCastlePossible = true;
    private boolean blackKsCastlePossible = true;
    private boolean whiteKsCastlePossible = true;
    private Coordinates enPassant = null;
    private GraveSingleton grave = GraveSingleton.getInstance();
    private ScoreboardSingleton scoreboard = ScoreboardSingleton.getInstance();

    public Chessboard() {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                board[j][i] = null;
            }
        }

        Attributes.colors col = Attributes.colors.white;
        int x = 0;
        for (int i = 0, j; i < 16; ++i) {
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
        for (int i = 0; i < 16; ++i) {
            if (i >= 8) {
                col = Attributes.colors.black;
                x = 6;
            }
            board[i % 8][x] = new Pawn(col);
        }
    }


    private Coordinates[] findFigure(Attributes.types type, Attributes.colors col) {
        Coordinates[] c = new Coordinates[8];
        for (int i = 0; i < 8; ++i) {
            c[i] = null;
        }

        int amount = 0;
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] != null) {
                    if (board[i][j].getType() == type && board[i][j].getCol() == col) {
                        c[amount] = new Coordinates(i, j);
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
    public boolean isGameOver(Attributes.colors col) {
        //if not check
        Coordinates c = getKing(col);
        if (!isCheck(c, col)) return false;

        //iterate through possibles moves for the King:
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                if (i == 0 && j == 0) continue;
                if (0 <= c.getX() + i && c.getX() + i < 8 && 0 <= c.getY() + j && c.getY() + j < 8) {
                    //if occupied and by the same color:
                    if (board[c.getX() + i][c.getY() + j] != null) {
                        if (board[c.getX() + i][c.getY() + j].getCol() == col) {
                            continue;
                        }
                    }

                    //if possible tryMove is not check:
                    Coordinates tmp = new Coordinates(c.getX() + i, c.getY() + j);
                    if (!isCheck(tmp, col)) return true;
                }
            }
        }
        return false;
    }

    private boolean isCheck(Coordinates coord, Attributes.colors col) {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] != null) {
                    if (board[i][j].getCol() != col && board[i][j].checkmove(i, j, coord.getX(), coord.getY(), board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void addGrave(Figure a) {
        //get color of current player.
        Attributes.colors col = Attributes.colors.white;
        if (a.getCol() == Attributes.colors.white) col = Attributes.colors.black;
        scoreboard.addScore(col, a.getType());
        grave.addGrave(a);
    }

    private void checkPromotion(parsedInput input, Coordinates c, Attributes.colors col) {
        if (board[c.getX()][c.getY()].getType() == Attributes.types.pawn) {
            if (c.getY() == 7 && col == Attributes.colors.white ||
                    c.getY() == 0 && col == Attributes.colors.black) {
                promotion(input, c, col);
            }
        }
    }

    private void promotion(parsedInput input, Coordinates c, Attributes.colors col) {
        Scanner keyboard = new Scanner(System.in);

        String a = "";
        if (input.getPawnPromo().length() != 0) a = input.getPawnPromo();
        while (!(a.equals("R") || a.equals("N") || a.equals("B") || a.equals("Q"))) {
            System.out.println("You managed to get a Pawn to the other side! What role do you want him to be? R / N / B / Q");
            a = keyboard.next();
        }

        switch (a) {
            case "R":
                board[c.getX()][c.getY()] = new Rook(col);
            case "N":
                board[c.getX()][c.getY()] = new Knight(col);
            case "B":
                board[c.getX()][c.getY()] = new Bishop(col);
            default:
                board[c.getX()][c.getY()] = new Queen(col);
        }
    }

    private boolean checkCastle(parsedInput i, Attributes.colors c) {
        //check if still doable
        if (c == Attributes.colors.white) {
            if (i.getKscasteling() && !whiteKsCastlePossible) return false;
            if (i.getQscasteling() && !whiteQsCastlePossible) return false;
        } else {
            if (i.getKscasteling() && !blackKsCastlePossible) return false;
            if (i.getQscasteling() && !blackQsCastlePossible) return false;
        }

        //check if possible
        int x = 0;
        if (c != Attributes.colors.white) x = 7;

        if (isCheck(getKing(c), c)) return false;
        Coordinates coords;
        if (i.getKscasteling()) {
            if (board[x][7].getType() != Attributes.types.rook) return false;
            for (int y = 5; y < 7; ++y) {
                if (board[x][y] != null) return false;
                coords = new Coordinates(x, y);
                if (isCheck(coords, c)) return false;
            }
        } else {
            if (board[x][0].getType() != Attributes.types.rook) return false;
            for (int y = 3; y > 1; --y) {
                if (board[x][y] != null) return false;
                coords = new Coordinates(x, y);
                if (isCheck(coords, c)) return false;
            }
            if (board[x][1] != null) return false;
        }

        if (c == Attributes.colors.white) {
            whiteKsCastlePossible = false;
            whiteQsCastlePossible = false;
        } else {
            blackKsCastlePossible = false;
            blackQsCastlePossible = false;
        }
        return true;
    }

    private void disableCastle(parsedInput input, Coordinates coords, Attributes.colors col) {
        if (col == Attributes.colors.white) {
            if (input.getType() == Attributes.types.king) {
                whiteKsCastlePossible = false;
                whiteQsCastlePossible = false;
            } else if (input.getType() == Attributes.types.rook) {
                if (coords.getX() == 0 && coords.getY() == 0) whiteQsCastlePossible = false;
                else if (coords.getX() == 0 && coords.getY() == 7) whiteKsCastlePossible = false;
            }
        } else {
            if (input.getType() == Attributes.types.king) {
                blackKsCastlePossible = false;
                blackQsCastlePossible = false;
            } else if (input.getType() == Attributes.types.rook) {
                if (coords.getX() == 7 && coords.getY() == 0) blackQsCastlePossible = false;
                else if (coords.getX() == 7 && coords.getY() == 7) blackKsCastlePossible = false;
            }
        }
    }


    private void move(parsedInput input, Coordinates coords, Attributes.colors col) {
        disableCastle(input, coords, col);
        board[input.getX()][input.getY()] = board[coords.getX()][coords.getY()];
        board[coords.getX()][coords.getY()] = null;
        Coordinates tmp = new Coordinates(input.getX(), input.getY());
        checkPromotion(input, tmp, col);
    }

    private void setEnPassant(Figure a, int currY, int newY, int newX) {
        enPassant = null;
        if (a.getType() == Attributes.types.pawn && abs(currY - newY) == 2) {
            enPassant = new Coordinates(newX, newY);
        }
    }

    public boolean tryMove(parsedInput input, Attributes.colors col) {
        if (input.getQscasteling() || input.getKscasteling()) {
            return checkCastle(input, col);
        }

        //check if getCapture was done properly.
        if (board[input.getX()][input.getY()] != null) {
            if (!input.getCapture() || board[input.getX()][input.getY()].getCol() == col) return false;
        } else {
            if (input.getCapture()) {
                //check for en passant
                if (input.getType() == Attributes.types.pawn && enPassant != null) {
                    Coordinates[] coords = findFigure(input.getType(), col);
                    if (coords[0] == null) return false;

                    Figure[][] copy = board.clone();
                    for (int i = 0; i < coords.length && coords[i] != null; ++i) {
                        if (input.getX() == coords[i].getX() && input.getY() == coords[i].getY()) continue;

                        if (board[coords[i].getX()][coords[i].getY()].enPassant(coords[i].getX(), coords[i].getY(), input.getX(), input.getY(), copy, enPassant)) {
                            addGrave(board[enPassant.getX()][enPassant.getY()]);
                            board[enPassant.getX()][enPassant.getY()] = null;
                            enPassant = null;
                            move(input, coords[i], col);
                            return true;
                        }

                    }
                }

                //base case
                return false;
            }
        }

        if (input.getKscasteling() || input.getQscasteling()) {
            return checkCastle(input, col);
        }
        if (input.getPawnCapture()) {
            if (board[input.getX()][input.getY()].getType() == Attributes.types.pawn) {
                String stringCoords = input.getPawnCaptureEnd();
                parsedInput newCoord = new parsedInput(stringCoords);
                addGrave(board[newCoord.getX()][newCoord.getY()]);
            }

        }
        //find all figures that are still in the game
        Coordinates[] coords = findFigure(input.getType(), col);
        if (coords[0] == null) return false;

        Figure[][] copy = board.clone();
        for (int i = 0; i < coords.length && coords[i] != null; ++i) {
            if (input.getX() == coords[i].getX() && input.getY() == coords[i].getY()) continue;

            if (board[coords[i].getX()][coords[i].getY()].checkmove(coords[i].getX(), coords[i].getY(), input.getX(), input.getY(), copy)) {
                setEnPassant(board[coords[i].getX()][coords[i].getY()], coords[i].getY(), input.getY(), input.getX());
                if (input.getCapture()) addGrave(board[input.getX()][input.getY()]);
                move(input, coords[i], col);
                return true;
            }
        }
        //return checkCastle(input, col);
        return false;
    }

    public void boardOutput() {
        String x;
        for (int i = 7; i >= 0; --i) {
            x = "";
            for (int j = 0; j < 8; ++j) {
                if (board[j][i] == null) x += "[]";
                else x += board[j][i].figureOutput();
            }
            System.out.println(x);
        }
    }

    public Figure[] getBoard() {
        Figure[] newlist = new Figure[40];

        int x = 0;

        for (int i = 7; i >= 0; --i) {
            for (int j = 0; j < 8; ++j) {
                if (board[j][i] != null) {
                    newlist[x] = board[j][i];

                    x++;

                }
            }
        }
        return newlist;

    }
}




