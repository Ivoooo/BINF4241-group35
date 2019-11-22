public class RobotSetTimer implements Command{
    private Cleaningrobot cleaningrobot;

    public RobotSetTimer(Cleaningrobot r) {
        this.cleaningrobot = r;
    }

    @Override
    public void execute() {
        this.cleaningrobot.setTimer();
    }

}
