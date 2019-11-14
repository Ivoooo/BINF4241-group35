public class Smartphone {
    Command slot;
    public Smartphone(){}
    public void setCommand(Command c){
        slot = c;
    }
    public void pressonButton(){
        slot.execute();
    }
    public void pressoffbutton(){
        slot.execute();
    }
    public void pressUndo(){
        slot.undo();
    }
}
