public class Figure {
    private Attributes.colors col;
    private Attributes.types type;

    public Figure(String color, Attributes.  types type) {
        if(color.equals("white")) col = Attributes.colors.white;
        else col = Attributes.colors.black;
        this.type = type;
    }

    public Attributes.colors getCol() {
        return col;
    }

    public Attributes.types getType() {
        return type;
    }

    public boolean checkmove(int current_x, int current_y, int new_x, int new_y) {
        return false;
    }

    public String figureOutput() {
        String x = "[";
        if (this.col == Attributes.colors.white) x += "W";
        else x += "B";

        if (this.type == Attributes.types.bishop) x += "B";
        else if (this.type == Attributes.types.king) x += "K";
        else if (this.type == Attributes.types.queen) x += "Q";
        else if (this.type == Attributes.types.pawn) x += "P";
        else if (this.type == Attributes.types.knight) x += "N";
        else x += "R";

        x += "]";
        return x;
    }
}