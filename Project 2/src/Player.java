public class Player {
    private String name;
    private Attributes.colors col;

    public Player(String name, String color) {
        this.name = name;
        if (color.equals("white")) col = Attributes.colors.white;
        else col = Attributes.colors.black;
    }

    public String getName() {
        return name;
    }

    public Attributes.colors getCol() {
        return col;
    }
}
