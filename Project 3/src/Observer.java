public interface Observer {
    boolean isGameOver(Attributes.colors col);
    boolean tryMove(parsedInput input, Attributes.colors col);
    void boardOutput();
}
