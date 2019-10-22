public class King extends Figure {

    public King(Attributes.colors color) {
        super(color, Attributes.types.king);
    }
    public boolean checkmove(int current_x, int current_y, int new_x, int new_y) {

        //todo check where he even can go (because of check)
        //todo start new game -> Kd5 -> works?
        if((new_x-current_x > 1 || new_x-current_x <-1) && (new_y-current_y > 1 || new_y-current_y < -1)) return false;
        else return true;
    }
}