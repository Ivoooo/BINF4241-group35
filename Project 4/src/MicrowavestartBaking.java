public class MicrowavestartBaking implements Command {
    private Microwave microwave;

    public MicrowavestartBaking(Microwave l){
        this.microwave = l;
    }

    @Override
    public void execute() {
        microwave.startBaking();
    }
}
