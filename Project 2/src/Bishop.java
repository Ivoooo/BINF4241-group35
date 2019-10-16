public class Bishop extends Figur {
    private types type = types.bishop;
    private colors col;
    private Coordinates coordinate;
    public Bishop(String color) {
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
        if (!(x2 - x == y2 -y))return false;
        else return true;
    }
}
