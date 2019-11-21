public class WashingMachineOff implements Command {
    private WashingMachine washingMachine;

    public WashingMachineOff(WashingMachine l){
        this.washingMachine = l;
    }

    @Override
    public void execute() {
        washingMachine.off();
    }
}
