public class DishwasherStop implements Command {
    private Dishwasher dishwasher;

    public DishwasherStop(Dishwasher i) {
        this.dishwasher = i;
    }

    @Override
    public void execute() {
        this.dishwasher.stop();
    }
}