public class OventurnOff implements Command {
    Oven oven;

    public OventurnOff(Oven l){
        this.oven = l;
    }

    @Override
    public void execute() {
        oven.turnoff();
    }
}
