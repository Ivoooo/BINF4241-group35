public class RobotStartClean implements Command {
    private Cleaningrobot cleaningrobot;
    public RobotStartClean(Cleaningrobot r) {
         this.cleaningrobot = r;
    }

    @Override
        public void execute() {
            this.cleaningrobot.startClean();
        }
}

