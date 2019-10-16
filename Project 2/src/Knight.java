public class Knight extends Figur {
    public Knight(String color) {
        super(color, types.knight);
    }
    public boolean checkmove(int current_x, int current_y, int new_x, int new_y){

        if (new_x - current_x == 1 || new_x - current_x == -1  && new_y - current_y == 2) return true; // Bewegung rechts oder links "diagnoal" nach oben
        if(new_x - current_x == 2 ||new_x - current_x == -2 && new_y - current_y == 1) return true; // Bewegung links oder rechts 45 grad nach oben
        if (new_x - current_x == 1 || new_x - current_x == -1 && new_y- current_y == -2) return true; // Bewegung rechts oder links diagonal nach unten
        if (new_x - current_x == 2 || new_x - current_x == -2 && new_y- current_y == -1) return true;//Bewegung links oder rechts 45 grad nach unten
        else return false;
    }
}
