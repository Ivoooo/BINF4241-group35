public class OvensetTimer implements Command {
    Oven oven;

    public OvensetTimer(Oven l){
        this.oven= l;
    }

    @Override
    public void execute() {
        oven.setTimer();
    }
}
