public class Queen extends Figur {
    private types type = types.queen;
    private colors col;

    public Queen(String color) {
        if(color.equals("white"))col = colors.white;
        else col = colors.black;
    }
}