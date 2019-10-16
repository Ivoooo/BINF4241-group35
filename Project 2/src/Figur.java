public class Figur {
    public enum types {
        king,
        queen,
        knight,
        pawn,
        rook,
        bishop,

    }
    public enum colors{
        black,
        white,
    }

    private colors col;
    private types type;

    public Figur(String color, types type) {
        if(color.equals("white")) col = colors.white;
        else col = colors.black;
        this.type = type;
    }

    public colors getCol() {
        return col;
    }

    public types getType() {
        return type;
    }
}
