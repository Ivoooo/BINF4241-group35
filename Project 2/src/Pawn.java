public class Pawn extends Figure {
    public Pawn(Attributes.colors color) {
        super(color, Attributes.types.pawn);
    }
    public boolean checkmove(int current_x, int current_y, int new_x, int new_y){

        if(new_y == 4 && current_y == 2) return true;
        if(new_y == 5 && current_y == 7) return true;
        if(new_x - current_x == 0 && new_y - current_y == 1) return true;
        if(new_x - current_x == 0 && new_y - current_y == -1) return true;
        else return false;


        //decide which direction to go
        int step = 1;
        if(super.getCol() == Attributes.colors.black) step = -1;

        //check for special case (starting point)
        if (super.getCol() == Attributes.colors.white && current_y == 1 ||
                super.getCol() == Attributes.colors.black && current_y == 7) {
            if (new_x - current_x == 0 && new_y - current_y == 2*step) {
                return true;
            }
        }

        //todo check killing someone (going left / right)

        //general movement
        return new_x - current_x == 0 && new_y - current_y == step;

    }
}
