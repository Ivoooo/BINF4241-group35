public class Rook extends Figur {
    private types type = types.rook;
    private colors col;
    private Coordinates coordinate;
    public Rook(String color) {
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
        if(x2 - x = 0 && y2 -y != 0) return true;
        if(y2 - y = 0 && x2- x != 0) return true;
        else return false;

    }
}
