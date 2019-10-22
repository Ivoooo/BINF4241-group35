public class Queen extends Figure {
    public Queen(Attributes.colors color) {
        super(color, Attributes.types.queen);
    }
    public boolean checkmove(int current_x, int current_y, int new_x, int new_y, Figure[][] board) {
        if(new_x - current_x == new_y -current_y) return true;
        if(new_x - current_x == 0 && new_y - current_y != 0) return true;
        if(new_y - current_y == 0 && new_x- current_x != 0) return true;
        else return false;

    }
}
