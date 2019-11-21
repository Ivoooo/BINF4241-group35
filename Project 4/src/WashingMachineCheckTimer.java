public class WashingMachineCheckTimer implements Command {
    WashingMachine washingMachine;
    public WashingMachineCheckTimer(WashingMachine l){
        this.washingMachine = l;
    }

    @Override
    public void execute() {
        washingMachine.checkTimer();
    }
}
