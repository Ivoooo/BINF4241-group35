public class MicrowavesetTemperature implements Command {
    private Microwave microwave;
    public MicrowavesetTemperature(Microwave l){
        this.microwave = l;
    }

    @Override
    public void execute() {
        microwave.setTemperature();
    }
}
