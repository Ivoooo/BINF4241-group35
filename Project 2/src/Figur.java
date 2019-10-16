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
}
