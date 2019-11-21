public class WashingMachineChooseProgram implements Command {
    private WashingMachine washingMachine;

    public WashingMachineChooseProgram(WashingMachine l){
        this.washingMachine = l;
    }

    @Override
    public void execute() {
        washingMachine.chooseProgram();
    }
}
