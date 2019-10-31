import static java.lang.Math.abs;

public class Knight extends Figure {
    public Knight(Attributes.colors color) {
        super(color, Attributes.types.knight);
    }

    public boolean checkmove(int current_x, int current_y, int new_x, int new_y, Figure[][] board){
        return (abs(current_x - new_x) == 2 && abs(current_y - new_y) == 1 ||
                abs(current_x - new_x) == 1 && abs(current_y - new_y) == 2);
    }
}