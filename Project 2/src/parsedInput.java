import java.lang.*;

public class parsedInput {
    private int x;
    private int y;
    private Attributes.types type;
    private boolean capture;
    private boolean isCheckmate;
    private boolean kscasteling;
    private boolean qscasteling;
    private boolean isCheck;
    private int oldposition;

    public parsedInput(String i) {
        capture = returnCapture(i);
        kscasteling = returnKingsidecasteling(i);
        qscasteling = returnQueensidecasteling(i);
        isCheck = returnCheck(i);
        isCheckmate = returnCheckmate(i);
        oldposition = Disambiguation(i);

        x = returnX(i);
        y = returnY(i);
        type = returnType(i);
    }

    public boolean getQscasteling(){return qscasteling;}

    public boolean getKscasteling(){return kscasteling;}

    public boolean getCheckmate() {
        return isCheckmate;
    }

    public boolean getisCheck(){return isCheck;}

    public int getOldposition() {
        return oldposition;
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

    private static int Disambiguation(String input){
        String [] characters = input.split("");
      if (input.length() == 4 | input.length() == 5 ){
            if (input.length() == 4){
                String alt = characters[1];
                if (alt.matches(".*\\d.*")) {
                    int yoldposition = Integer.parseInt(alt);
                    return yoldposition;
                }
                else {
                    int xoldposition = returnX(alt);
                    return xoldposition;
                     }
                }
            if (input.length() == 5){
                int yoldposition = Integer.parseInt(characters[2]);
                int xoldposition = returnX(characters[1]);
                return xoldposition;
            }
        }

    }

    private static int returnX(String input){
        String checkedInput = checkPawn(input);
        if (returnCheck(input)) input = input.replace("+", "");
        if(returnCheckmate(input)) input = input.replace("#", "");
        if(input.length() == 4) input = input.substring(0,0) + input.substring(2,3);
        if(input.length() == 4) input = input.substring(0,0) + input.substring(3,4);
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
        if (returnCheck(input)) input = input.replace("+", "");
        if(returnCheckmate(input)) input = input.replace("#", "");
        if(input.length() == 4) input = input.substring(0,0) + input.substring(2,3);
        if(input.length() == 4) input = input.substring(0,0) + input.substring(3,4);
        String[] characters = checkedInput.split("");
        return Integer.parseInt(characters[2]) - 1;
    }

    private static boolean returnCapture(String input){
        return (input.contains("x") || input.contains("X") || input.contains(":"));
    }
    private static boolean returnKingsidecasteling(String input){
        if (input == ("0-0")) {
            return true;
        }
        else return false;
    }
    private static boolean returnQueensidecasteling(String input){
        if (input == ("0-0-0")) {
            return true;
        }

        else return false;
    }
    private static boolean returnCheck(String input){
        if (input.contains("+")) {
            return true;
        }
        else return false;
    }

    private static boolean returnCheckmate(String input){
        if (input.contains("#")) {
            return true;
        }
        else return false;
    }




}
