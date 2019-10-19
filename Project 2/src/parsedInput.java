import java.lang.*;

public class parsedInput {
    private int x;
    private int y;
    private Attributes.types type;
    private boolean capture;

    public parsedInput(String i) {
        x = returnX(i);
        y = returnY(i);
        type = returnType(i);
        capture = returnCapture(i);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Attributes.types getType() {
        return type;
    }

    public boolean getCapture() {
        return capture;
    }

    private static String checkPawn(String input){
        if (input.length() == 2){
            StringBuilder newString = new StringBuilder(input);
            newString.insert(0, "P");
            return newString.toString();
        }
        else return input;
    }

    private static int returnX(String input){
        String checkedInput = checkPawn(input);
        String [] characters = checkedInput.split("");
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

    private static Attributes.types returnType(String input){
        String checkedInput = checkPawn(input);
        String[] characters = checkedInput.split("");
        String figure = characters[0];

        switch(figure){
            case "Q":
               return Attributes.types.queen;

            case "K":
                return Attributes.types.king;

            case "N":
                return Attributes.types.knight;

            case "R":
                return Attributes.types.rook;

            case "B":
                return Attributes.types.bishop;

            case "P":
                return Attributes.types.pawn;
        }

        return null;
    }

    private static int returnY(String input){
        String checkedInput = checkPawn(input);
        String[] characters = checkedInput.split("");
        return Integer.parseInt(characters[2]) - 1;
    }

    private static boolean returnCapture(String input){
        return (input.contains("x") || input.contains("X") || input.contains(":"));
    }
}
