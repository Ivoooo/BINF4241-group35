public class Smartphone {
    Command slot;
    public Smartphone(){}
    public void setCommand(Command c){
        slot = c;
    }
    public void pressonButton(){
        slot.execute();
    }
}
