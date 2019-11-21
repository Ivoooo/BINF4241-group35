public class OvencheckTimer implements Command {
    private Oven oven;

    public OvencheckTimer(Oven l){
        this.oven =l;
    }

    @Override
    public void execute() {
        oven.checkTimer();
    }
}
