public class MicrowavecheckTimer implements Command {
    private Microwave microwave;

    public MicrowavecheckTimer(Microwave l){
        this.microwave = l;
    }

    @Override
    public void execute() {
        microwave.checkTimer();
    }
}
