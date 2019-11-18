public class DishwasherSwitchOn implements Command {
    private Dishwasher dishwasher;

    public DishwasherSwitchOn(Dishwasher i) {
        this.dishwasher = i;
    }

    @Override
    public void execute() {
        this.dishwasher.on();
    }
}