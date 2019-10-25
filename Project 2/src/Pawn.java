import static java.lang.Math.abs;

public class Pawn extends Figure {
    public Pawn(Attributes.colors color) {
        super(color, Attributes.types.pawn);
    }
    public boolean checkmove(int current_x, int current_y, int new_x, int new_y, Figure[][] board){
        //decide which direction to go
        int step = 1;
        if(super.getCol() == Attributes.colors.black) step = -1;

        //check for special case (starting point)
        if (super.getCol() == Attributes.colors.white && current_y == 1 ||
                super.getCol() == Attributes.colors.black && current_y == 6) {
            if (new_x - current_x == 0 && new_y - current_y == 2*step &&
                    board[new_x][new_y] == null) return true;
        }

        if (new_y - current_y == step) {
            if(new_x - current_x == 0 && board[new_x][new_y] == null) return true;
            return abs(new_x - current_x) == 1 && board[new_x][new_y] != null;
        }

        return false;
    }

    public boolean enPassant(int current_x, int current_y, int new_x, int new_y, Figure[][] board, Coordinates enemy) {
        if (board[new_x][new_y] != null || board[current_x][current_y] == null) return false;

        //check (on copy) if we could move there
        if(super.getCol() == Attributes.colors.white) board[new_x][new_y] = new Pawn(Attributes.colors.black);
        else board[new_x][new_y] = new Pawn(Attributes.colors.white);
        if(!checkmove(current_x, current_y, new_x, new_y, board)) return false;

        if (abs(current_x - new_x) != 1 && abs(current_y - new_y) != 1) return false;

        return (enemy.getX() == new_x && enemy.getY() == current_y);
    }
}
