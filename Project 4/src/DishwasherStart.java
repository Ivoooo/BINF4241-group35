public class DishwasherStart implements Command {
    private Dishwasher dishwasher;

    public DishwasherStart(Dishwasher i) {
        this.dishwasher = i;
    }

    @Override
    public void execute() {
        this.dishwasher.start();
    }
}