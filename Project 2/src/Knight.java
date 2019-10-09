public class Knight extends Figur {
    private types type = types.knight;
    private colors col;

    public Knight(String color) {
        if(color.equals("white"))col = colors.white;
        else col = colors.black;
    }
}
