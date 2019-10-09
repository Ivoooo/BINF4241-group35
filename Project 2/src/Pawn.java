public class Pawn extends Figur {
    private types type = types.pawn;
    private colors col;

    public Pawn(String color) {
        if(color.equals("white"))col = colors.white;
        else col = colors.black;
    }
}
