public class MicrowavestopBaking implements Command {
    private Microwave microwave;

    public MicrowavestopBaking(Microwave l){
        this.microwave = l;
    }

    @Override
    public void execute() {
        microwave.stopBaking();
    }
}
