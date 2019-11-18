public class OvenstartBaking implements Command {
    Oven oven;

    public OvenstartBaking(Oven l){
        this.oven = l;
    }

    @Override
    public void execute() {
        oven.startBaking();
    }
}
