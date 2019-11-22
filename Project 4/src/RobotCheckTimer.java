public class RobotCheckTimer implements Command {
    private Cleaningrobot cleaningrobot;
    public RobotCheckTimer(Cleaningrobot r) {
            this.cleaningrobot = r;
        }

        @Override
        public void execute() {
            this.cleaningrobot.checkTimer();
        }
}



