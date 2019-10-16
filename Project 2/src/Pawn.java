public class Pawn extends Figur {
    private types type = types.pawn;
    private colors col;
    private Coordinates coordinate;
    public Pawn(String color) {
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
        // how do we know if it's the first move or not
        // first time pawn is able to jump 2 fields
        return x2 - x == 0 && y2 - y == 1;

    }
}
