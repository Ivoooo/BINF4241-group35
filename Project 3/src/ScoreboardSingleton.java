import java.util.Arrays;

public class ScoreboardSingleton {
    private static ScoreboardSingleton uniqueInstance;
    private ScoreboardSingleton(){}
    private int[] scores = {0,0};

    public static ScoreboardSingleton getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new ScoreboardSingleton();
        }
        return uniqueInstance;
    }

    public void addScore(Attributes.colors col, Attributes.types type) {
        if (col == Attributes.colors.white && type == Attributes.types.queen) scores[0] += 5;
        else if (col == Attributes.colors.white) scores[0] += 1;
        else if (type == Attributes.types.queen) scores[1] += 5;
        else scores[1] += 1;
    }

    public void printScore() {
        System.out.println("Player 1, score: " + scores[0] + " - Player 2, score: " + scores[1]);
    }
}
