public class Microwave implements Command {
    Microwave microwave;
    public turnMicrowaveon(Microwave l){
        this.microwave = l;
    }
    public void execute(){
        //if thread schon am ausführen: turnoff
        // else thread ausführen
    }
    public void undo(){}
}
