public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Game gameboard = new Game(14);

        System.out.println(gameboard.getTiles());
    }

}

class Game {
    Game(int tile) {
        this.tiles = tile;
    }

    int getTiles() {
        return this.tiles;
    }

    int tiles;

}