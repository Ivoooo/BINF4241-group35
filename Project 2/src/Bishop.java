public class Bishop extends Figure {
    public Bishop(String color) {
        super(color, Attributes.types.bishop);
    }
    public boolean checkmove(int current_x, int current_y, int new_x, int new_y){
        if (!(new_x - current_x == new_y -current_y))return false;
        else return true;
    }
}