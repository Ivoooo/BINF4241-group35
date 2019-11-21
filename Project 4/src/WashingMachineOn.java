public class WashingMachineOn implements Command {
    private WashingMachine washingMachine;

    public WashingMachineOn(WashingMachine l){
        this.washingMachine = l;
    }

    @Override
    public void execute() {
        washingMachine.on();
    }
}
