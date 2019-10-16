public class King extends Figur {
    private Coordinates coordinate;

    public King(String color) {
        super(color, types.king);
    }
    public boolean checkmove() {
        int x;
        int y;
        x = coordinate.getX();
        y = coordinate.getY();
        // x2 = coordinate.movingX();
        // y2 = coordinate.movingY();
        if((x2-x > 1 || x2-x <-1) && (y2-y > 1 || y2-y < -1)) return false;
        else return true;

    }
}