public class RobotCheckCleaningProgress implements Command {
    Cleaningrobot cleaningrobot;
    public RobotCheckCleaningProgress(Cleaningrobot r) {
            this.cleaningrobot = r;
        }

        @Override
        public void execute() {
            this.cleaningrobot.checkCleaning();
        }
}



