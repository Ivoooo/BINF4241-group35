public class OvensetTemperature implements Command {
    Oven oven;

    public OvensetTemperature(Oven l){
        this.oven = l;
    }

    @Override
    public void execute() {
        oven.setTemperature();
    }
}
