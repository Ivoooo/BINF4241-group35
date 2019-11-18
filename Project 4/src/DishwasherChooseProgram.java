public class DishwasherChooseProgram implements Command {
    private Dishwasher dishwasher;

    public DishwasherChooseProgram(Dishwasher i) {
        this.dishwasher = i;
    }

    @Override
    public void execute() {
        this.dishwasher.chooseProgram();
    }
}