public class OvensetTemperature implements Command {
    private Oven oven;

    public OvensetTemperature(Oven l){
        this.oven = l;
    }

    @Override
    public void execute() {
        oven.setTemperature();
    }
}
