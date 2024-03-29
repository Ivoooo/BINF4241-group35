import static java.lang.Math.abs;

public class Bishop extends Figure {
    public Bishop(Attributes.colors color) {
        super(color, Attributes.types.bishop);
    }

    public boolean checkmove(int current_x, int current_y, int new_x, int new_y, Figure[][] board) {
        if (abs(new_x - current_x) != abs(new_y - current_y)) return false;
        if (new_x - current_x > 0) {
            for (++current_x; current_x < new_x; ++current_x) {
                if (new_y - current_y > 0) {
                    current_y += 1;
                    if (board[current_x][current_y] != null) return false;
                }
                else {
                    current_y -= 1;
                    if (board[current_x][current_y] != null) return false;


                }
            }
        }
        if (new_x - current_x < 0) {
            for (--current_x; current_x > new_x; --current_x) {
                if (new_y - current_y > 0) {
                    current_y += 1;
                        if (board[current_x][current_y] != null) return false;
                } else {
                    current_y -=1;
                        if (board[current_x][current_y] != null) return false;

                }
            }

        }
        return true;
    }
}