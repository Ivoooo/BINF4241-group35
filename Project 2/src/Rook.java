public class Rook extends Figure {
    public Rook(Attributes.colors color) {
        super(color, Attributes.types.rook);
    }
    public boolean checkmove(int current_x, int current_y, int new_x, int new_y, Figure[][] board){
        if(new_y - current_y == 0 && new_x- current_x == 0) return false;
        if(new_x - current_x == 0){
            if(new_y - current_y > 0){
                for(++current_y;current_y < new_y; ++current_y){
                    if(board[current_x][current_y] != null) return false;
                }
            }
            else{
                for(--current_y;current_y > new_y; --current_y){
                    if(board[current_x][current_y] != null) return false;
                }

            }
        }
        if(new_y-current_y == 0){
            if(new_x - current_x > 0){
                for (++current_x;current_x < new_x; ++current_x){
                    if(board[current_x][current_y] != null) return false;
                }
            }
            else{
                for(--current_x;current_x > new_x; --current_x){
                    if(board[current_x][current_y] != null) return false;
                }
            }

        }
        return true;

    }
}
