import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(" Gamesize: ");
        Scanner keyboard = new Scanner(System.in);
        int gamesize = keyboard.nextInt();
        System.out.println("Your Game is of Size: " + gamesize);
        System.out.println("How many players want to play? ");
        int numplayers = keyboard.nextInt();

        HashMap<String, String> Players = new HashMap<String, String>();
        for (int i = 1 ; i <= numplayers;++i){
            Players.put("Player"+i ,"currentsquare");
        }
        for (String i : Players.keySet()) {
            System.out.println(i);
        }

        Game test = new Game();
        test.setSize(5);
        System.out.println(test.gamesize());
    }


}