public class Pawn extends Figure {
    public Pawn(String color) {
        super(color, Attributes.types.pawn);
    }
    public boolean checkmove(int current_x, int current_y, int new_x, int new_y){
        if(new_y == 4 && current_y == 2) return true;
        if(new_y == 5 && current_y == 7) return true;
        if(new_x - current_x == 0 && new_y - current_y == 1) return true;
        if(new_x - current_x == 0 && new_y - current_y == -1) return true;
        else return false;
    }
}
