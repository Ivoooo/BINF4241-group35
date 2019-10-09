public class King extends Figur {
    private types type = types.king;
    private colors col;

    public King(String color) {
        if(color.equals("white"))col = colors.white;
        else col = colors.black;
    }
}