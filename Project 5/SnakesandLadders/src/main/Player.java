package main;

public class Player {
    private String name;
    private int position = 0;

    public Player (String i) {
        this.name = i;
    }

    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }

    public void setPosition(int i){
        this.position = i;
    }
}