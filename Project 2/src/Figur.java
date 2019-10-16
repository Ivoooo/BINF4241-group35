public class Figur {
    private attributes.colors col;
    private attributes.types type;

    public Figur(String color, attributes.  types type) {
        if(color.equals("white")) col = attributes.colors.white;
        else col = attributes.colors.black;
        this.type = type;
    }

    public attributes.colors getCol() {
        return col;
    }

    public attributes.types getType() {
        return type;
    }

    public boolean checkmove(int current_x, int current_y, int new_x, int new_y) {
        return false;
    }

    public String figureOutput() {
        String x = "[";
        if (this.col == attributes.colors.white) x += "W";
        else x += "B";

        if (this.type == attributes.types.bishop) x += "B";
        else if (this.type == attributes.types.king) x += "K";
        else if (this.type == attributes.types.queen) x += "Q";
        else if (this.type == attributes.types.pawn) x += "P";
        else if (this.type == attributes.types.knight) x += "N";
        else x += "R";

        x += "]";
        return x;
    }
}
