public class Knight extends Figure {
    public Knight(Attributes.colors color) {
        super(color, Attributes.types.knight);
    }
    public boolean checkmove(int current_x, int current_y, int new_x, int new_y){
        if (new_x - current_x == 1 || new_x - current_x == -1  && new_y - current_y == 2 || new_y- current_y == -2) return true; // Bewegung rechts oder links "diagnoal" nach oben/unten
        if(new_x - current_x == 2 ||new_x - current_x == -2 && new_y - current_y == 1 || new_y- current_y == -1) return true; // Bewegung links oder rechts 45 grad nach oben/unten
        else return false;
    }
}