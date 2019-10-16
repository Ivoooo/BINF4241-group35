public class Knight extends Figur {
    private types type = types.knight;
    private colors col;
    private Coordinates coordinate;
    public Knight(String color) {
        if(color.equals("white"))col = colors.white;
        else col = colors.black;
    }
    public boolean checkmove(){
        int x;
        int y;
        x = coordinate.getX();
        y = coordinate.getY();
        // x2 = coordinate.movingX();
        // y2 = coordinate.movingY();
        if (x2 - x = 1 || x2 - x = -1  && y2 -y = 2) return true; // Bewegung rechts oder links "diagnoal" nach oben
        if(x2 - x = 2 ||x2 - x = -2 && y2 - y = 1) return true; // Bewegung links oder rechts 45 grad nach oben
        if (x2 - x = 1 || x2 - x = -1 && y2- y = -2) return true; // Bewegung rechts oder links diagonal nach unten
        if (x2 - x = 2 || x2 - x = -2 && y2- y = -1) return true;//Bewegung links oder rechts 45 grad nach unten
        else return false;
    }
}
