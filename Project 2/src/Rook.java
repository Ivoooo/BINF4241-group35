public class Rook extends Figur {
    private types type = types.rook;
    private colors col;

    public Rook(String color) {
        if(color.equals("white"))col = colors.white;
        else col = colors.black;
    }
}
