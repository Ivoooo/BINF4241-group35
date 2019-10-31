public class King extends Figure {

    public King(Attributes.colors color) {
        super(color, Attributes.types.king);
    }
    public boolean checkmove(int current_x, int current_y, int new_x, int new_y, Figure[][] board) {
        return !(new_x-current_x > 1 || new_x-current_x <-1 || new_y-current_y > 1 || new_y-current_y < -1);
    }
}