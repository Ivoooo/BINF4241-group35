public class OvensetProgram implements Command {
    Oven oven;

    public OvensetProgram(Oven l){
        this.oven = l;
    }

    @Override
    public void execute() {
        oven.setProgram();
    }
}
