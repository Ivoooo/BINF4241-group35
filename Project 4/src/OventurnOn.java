public class OventurnOn implements Command {
    private Oven oven;

    public OventurnOn(Oven l){
        this.oven = l;
    }

    @Override
    public void execute() {
        oven.turnOn();
    }
}
