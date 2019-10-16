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

    public Figur(String color) {
        if(color.equals("white")) col = colors.white;
        else col = colors.black;
    }

    public colors getCol() {
        return col;
    }
}
