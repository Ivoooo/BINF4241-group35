public class RobotCheckCleaningProgress implements Command {
    private Cleaningrobot cleaningrobot;
    public RobotCheckCleaningProgress(Cleaningrobot r) {
            this.cleaningrobot = r;
        }

        @Override
        public void execute() {
            this.cleaningrobot.checkCleaning();
        }
}



