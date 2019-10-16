public class Queen extends Figur {
    private types type = types.queen;
    private colors col;
    private Coordinates coordinate;
    public Queen(String color) {
        if(color.equals("white"))col = colors.white;
        else col = colors.black;
    }
    public boolean checkmove() {
        int x;
        int y;
        x = coordinate.getX();
        y = coordinate.getY();
        // x2 = coordinate.movingX();
        // y2 = coordinate.movingY();
        
    }
}
