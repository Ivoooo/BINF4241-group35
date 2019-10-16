import java.lang.*;
import java.security.KeyStore;

public class readInput {
    private int x;
    private int y;
    private String figure;


    public int returnX(String input){
        String [] characters = input.split("");
        String posx = characters[1];
        switch (posx) {
            case "a":
                x = 0;
                break;
            case "b":
                x =1;
                break;
            case "c":
                x =2;
                break;
            case "d":
                x =3;
                break;
            case "e":
                x =4;
                break;
            case "f":
                x =5;
                break;
            case "g":
                x =6;
                break;
            case "h":
                x =7;
                break;
        }
        return x;
    }
    public attributes.types returnType(String input){

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
                break;
        }

        return null;
    }
    public int returnY(String input){
        String[] characters = input.split("");
        y = Integer.parseInt(characters[2]);
        return y;
    }

    public boolean capture(String input){
        if (input.contains("x") || input.contains("X") || input.contains(":")) {
            return true;
        }else{
            return false;
        }
    }
}
