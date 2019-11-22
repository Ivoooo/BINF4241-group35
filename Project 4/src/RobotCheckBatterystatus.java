public class RobotCheckBatterystatus implements Command {
    private Cleaningrobot cleaningrobot;
    public RobotCheckBatterystatus(Cleaningrobot r) {
            this.cleaningrobot = r;
        }

        @Override
        public void execute() {
            this.cleaningrobot.checkBatteryStatus();
        }
}



