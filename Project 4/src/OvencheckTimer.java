public class OvencheckTimer implements Command {
    Oven oven;

    public OvencheckTimer(Oven l){
        this.oven =l;
    }

    @Override
    public void execute() {
        oven.checkTimer();
    }
}
