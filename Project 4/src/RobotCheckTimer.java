public class RobotCheckTimer implements Command {
    Cleaningrobot cleaningrobot;
    public RobotCheckTimer(Cleaningrobot r) {
            this.cleaningrobot = r;
        }

        @Override
        public void execute() {
            this.cleaningrobot.checkTimer();
        }
}



