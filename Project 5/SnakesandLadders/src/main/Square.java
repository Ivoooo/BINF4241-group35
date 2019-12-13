package main;

import java.util.Vector;

public class Square {
    private enum SquareTypes {
        START,
        FINISH,
        SNAKE,
        LADDER,
        NORMAL,
    }

    private SquareTypes type = SquareTypes.NORMAL;
    private Vector<String> occupants = new Vector<>();
    private int destination = 0; //either destination of Snake/Ladder or start tile.

    public void leave(String name){
        int i = occupants.indexOf(name);
        if(i >= 0) occupants.remove(i);
    }

    public Boolean tryMove (String name){
        if (type != SquareTypes.SNAKE && type != SquareTypes.LADDER) {
            occupants.add(name);
            return true;
        }
        return false;
    }

    public void makeShortcut(int destination, String type) {
        if(destination < 0) {
            this.destination = 0;
            return;
        }
        this.destination = destination;
        if (type.equals("SNAKE")) {
            this.type = SquareTypes.SNAKE;
        }
        else {
            this.type = SquareTypes.LADDER;
        }
    }

    public int getDestination() {
        return this.destination;
    }

    public void setStart() {
        type = SquareTypes.START;
    }

    public void setFinish() {
        type = SquareTypes.FINISH;
    }

    public Boolean isOccupied() {
        return (occupants.size() > 0 && type != SquareTypes.START);
    }

    public String repr(int position) {
        if(position < 0) return null;
        position++; //because in real life it starts at 1
        int dest = destination + 1;
        String str = "[" + position;

        if (type != SquareTypes.SNAKE && type != SquareTypes.LADDER) {
            for(int i=0; i < occupants.size(); ++i) {
                str += '<' + occupants.get(i) + '>';
            }
            return str + "]";
        }
        else if (type == SquareTypes.SNAKE) {
            return "[" + dest + "<-" + position + ']';
        }
        return str + "->" + dest + ']';
    }
}
