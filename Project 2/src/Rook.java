public class Rook extends Figure {
    public Rook(Attributes.colors color) {
        super(color, Attributes.types.rook);
    }
    public boolean checkmove(int current_x, int current_y, int new_x, int new_y){
        if(new_x - current_x == 0 && new_y - current_y != 0) return true;
        if(new_y - current_y == 0 && new_x- current_x != 0) return true;
        else return false;

    }
}
