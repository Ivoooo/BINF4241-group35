public class MicrowavecheckTimer implements Command {
    Microwave microwave;

    public MicrowavecheckTimer(Microwave l){
        this.microwave = l;
    }

    @Override
    public void execute() {
        microwave.checkTimer();
    }
}
