public class Bishop extends Figur {
    private types type = types.bishop;
    private colors col;

    public Bishop(String color) {
        if(color.equals("white"))col = colors.white;
        else col = colors.black;
    }
}
