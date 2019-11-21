public class OvenstopBaking implements Command {
    private Oven oven;

    public OvenstopBaking(Oven l){
        this.oven = l;
    }

    @Override
    public void execute() {
        oven.stopBaking();
    }
}
