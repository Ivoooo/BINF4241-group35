public class OvenstopBaking implements Command {
    Oven oven;

    public OvenstopBaking(Oven l){
        this.oven = l;
    }

    @Override
    public void execute() {
        oven.stopBaking();
    }
}
