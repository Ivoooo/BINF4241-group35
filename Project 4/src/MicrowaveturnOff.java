public class MicrowaveturnOff implements Command {
    Microwave microwave;

    public MicrowaveturnOff(Microwave l){
        this.microwave = l;
    }

    @Override
    public void execute() {
        microwave.turnoff();
    }
}
