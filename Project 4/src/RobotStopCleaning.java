public class RobotStopCleaning implements Command {
    private Cleaningrobot cleaningrobot;
    public RobotStopCleaning(Cleaningrobot r) {
        this.cleaningrobot = r;
    }

    @Override
    public void execute() {
        this.cleaningrobot.stopCleaning();
    }
}