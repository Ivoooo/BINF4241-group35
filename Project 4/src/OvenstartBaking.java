public class OvenstartBaking implements Command {
    private Oven oven;

    public OvenstartBaking(Oven l){
        this.oven = l;
    }

    @Override
    public void execute() {
        oven.startBaking();
    }
}
