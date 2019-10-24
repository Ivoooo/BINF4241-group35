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
            if (new_x - current_x == 0 && new_y - current_y == 2*step) {
                return true;
            }
        }

        //todo test if killing with pawn, diagonal move possible
        if(abs(new_x - current_x) == 1 && abs(new_y - current_y) == 1){
            if(board[current_x+1][current_y+1] == null) return false;
            if(board[current_x+1][current_y-1] == null)return false;
            if(board[current_x-1][current_y+1] == null) return false;
            if(board[current_x-1][current_y-1] == null) return false;
            return true;
        }


        //general movement
        return new_x - current_x == 0 && new_y - current_y == step;

    }
}
