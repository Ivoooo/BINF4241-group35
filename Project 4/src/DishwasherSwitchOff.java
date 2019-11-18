public class DishwasherSwitchOff implements Command {
    private Dishwasher dishwasher;

    public DishwasherSwitchOff(Dishwasher i) {
        this.dishwasher = i;
    }

    @Override
    public void execute() {
        this.dishwasher.off();
    }
}