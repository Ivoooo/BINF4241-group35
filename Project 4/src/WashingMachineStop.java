public class WashingMachineStop implements Command {
    private WashingMachine washingMachine;

    public WashingMachineStop(WashingMachine l){
        this.washingMachine = l;
    }

    @Override
    public void execute() {
        washingMachine.stop();
    }
}
