public class Player {
    private String name;
    private attributes.colors col;

    public Player(String name, String color) {
        this.name = name;
        if (color.equals("white")) col = attributes.colors.white;
        else col = attributes.colors.black;
    }

}
