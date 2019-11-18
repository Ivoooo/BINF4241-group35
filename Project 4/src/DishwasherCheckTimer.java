public class DishwasherCheckTimer implements Command {
    private Dishwasher dishwasher;

    public DishwasherCheckTimer(Dishwasher i) {
        this.dishwasher = i;
    }

    @Override
    public void execute() {
        this.dishwasher.checkTimer();
    }
}