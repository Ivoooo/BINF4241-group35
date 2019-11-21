public class MicrowaveturnOn implements Command {
    Microwave microwave;

    public MicrowaveturnOn(Microwave l){
        this.microwave = l;
    }

    @Override
    public void execute() {
        microwave.turnOn();
    }
}
