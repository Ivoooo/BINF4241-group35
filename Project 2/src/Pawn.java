public class Pawn extends Figure {
    public Pawn(String color) {
        super(color, Attributes.types.pawn);
    }
    public boolean checkmove(int current_x, int current_y, int new_x, int new_y){
        // how do we know if it's the first move or not
        // first time pawn is able to jump 2 fields
        return new_x - current_x == 0 && new_y - current_y == 1;

    }
}
