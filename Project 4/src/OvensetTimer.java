public class OvensetTimer implements Command {
    private Oven oven;

    public OvensetTimer(Oven l){
        this.oven= l;
    }

    @Override
    public void execute() {
        oven.setTimer();
    }
}
