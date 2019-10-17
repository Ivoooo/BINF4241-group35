import java.lang.*;

public class inputParser {
    public static int returnX(String input){
        String [] characters = input.split("");
        String posx = characters[1];
        switch (posx) {
            case "a":
                return 0;
            case "b":
                return 1;
            case "c":
                return 2;
            case "d":
                return 3;
            case "e":
                return 4;
            case "f":
                return 5;
            case "g":
                return 6;
            case "h":
                return 7;
            default:
                return -1;
        }
    }

    public static attributes.types returnType(String input){

        String[] characters = input.split("");
        String figure = characters[0];
        switch(figure){
            case "Q":
               return attributes.types.queen;

            case "K":
                return attributes.types.king;

            case "N":
                return attributes.types.knight;

            case "R":
                return attributes.types.rook;

            case "B":
                return attributes.types.bishop;

            case "P":
                return attributes.types.pawn;
        }

        return null;
    }
    public static int returnY(String input){
        String[] characters = input.split("");
        return Integer.parseInt(characters[2]) - 1;
    }

    public static boolean capture(String input){
        return (input.contains("x") || input.contains("X") || input.contains(":"));
    }
}
