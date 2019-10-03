import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(" Choose your game size: ");
        Scanner keyboard = new Scanner(System.in);
        int size = keyboard.nextInt();
        Game ourGame = new Game();
        ourGame.setSize(size);
        System.out.println("Your Game is of Size: " + ourGame.getSize());

        System.out.println("How many players want to play? ");
        int numplayers = keyboard.nextInt();

        HashMap<String, String> Players = new HashMap<String, String>();
        for (int i = 1 ; i <= numplayers;++i){
            Players.put("Player"+i ,"currentsquare");
        }
        for (String i : Players.keySet()) {
            System.out.println(i);
        }
    }


}