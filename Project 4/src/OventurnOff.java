public class OventurnOff implements Command {
    private Oven oven;

    public OventurnOff(Oven l){
        this.oven = l;
    }

    @Override
    public void execute() {
        oven.turnoff();
    }
}
