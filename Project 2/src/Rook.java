public class Rook extends Figure {
    public Rook(Attributes.colors color) {
        super(color, Attributes.types.rook);
    }
    public boolean checkmove(int current_x, int current_y, int new_x, int new_y, Figure[][] board){
        if(new_y - current_y == 0 && new_x- current_x == 0) return false;
        if(new_x - current_x == 0){
            int step = -1;
            if(new_y - current_y > 0) step = 1;
            for(current_y += step;current_y < new_y; current_y += step){
                if(board[current_x][current_y] != null) return false;
            }
            return true;
        }
        else if(new_y-current_y == 0){
            int step = -1;
            if(new_x - current_x > 0) step = 1;
            for(current_x += step;current_x < new_x; current_x += step){
                if(board[current_x][current_y] != null) return false;
            }
            return true;
        }
        return false;
    }
}
