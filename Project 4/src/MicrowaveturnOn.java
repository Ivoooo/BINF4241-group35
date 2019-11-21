public class MicrowaveturnOn implements Command {
    private Microwave microwave;

    public MicrowaveturnOn(Microwave l){
        this.microwave = l;
    }

    @Override
    public void execute() {
        microwave.turnOn();
    }
}
