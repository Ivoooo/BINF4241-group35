public class Player {
    private String name;

    public String setName(String i) {
        this.name = i;
        return this.name;

    }
    public String getName(){
        return this.name;
    }

    public int setPosition(){

        return 0;
    }
    public int moveFwd(int i){
        Square.leave(this.player);
        Square.MoveandLand(i);
        return 0;



        return 0;
    }


}