public class Player {
    private enum Color {
        white,
        black
    }

    private String name;
    private Color col;

    public Player(String name, String color) {
        this.name = name;
        if (color.equals("white")) col = Color.white;
        else col = Color.black;
    }



}
