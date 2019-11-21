public class MicrowavesetTimer implements Command {
    private Microwave microwave;

    public MicrowavesetTimer(Microwave l){
        this.microwave = l;
    }
    @Override
    public void execute(){
        microwave.setTimer();
    }

}
