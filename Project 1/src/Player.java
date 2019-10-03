public class Player {
    private int player;

    public int setName(int i) {
        this.player = i;
        return 0;

    }
    public int getName(){
        return this.player;
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
