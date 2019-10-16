import java.lang.*;

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
    public void returnFigure(String input) {
        String[] characters = input.split("");
        figure = characters[0];
        switch(figure){
            case "Q":
                 Figur.types.queen;
            case "K":

        }
    }
    public int returnY(String input){
        String[] characters = input.split("");
        y = Integer.parseInt(characters[2]);
    }

}
