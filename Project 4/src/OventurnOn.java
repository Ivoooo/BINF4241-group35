public class OventurnOn implements Command {
    Oven oven;

    public OventurnOn(Oven l){
        this.oven = l;
    }

    @Override
    public void execute() {
        oven.turnOn();
    }
}
