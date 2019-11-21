public class WashingMachineSetTemperature implements Command {
    private WashingMachine washingMachine;

    public WashingMachineSetTemperature(WashingMachine l){
        this.washingMachine = l;
    }

    @Override
    public void execute() {
        washingMachine.setTemperature();
    }
}
