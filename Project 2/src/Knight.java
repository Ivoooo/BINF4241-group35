public class Knight extends Figur {
    private types type = types.knight;
    private colors col;
    public Coordinates coordinate;
    public Knight(String color) {
        if(color.equals("white"))col = colors.white;
        else col = colors.black;
    }
    public class checkmove(){
        int coordinates;
        // coordinates = cordinate.getnumber();
    }
}
