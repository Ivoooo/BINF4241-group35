public class RobotStart implements Command {
    Cleaningrobot cleaningrobot;
    public RobotStart(Cleaningrobot r) {
            this.cleaningrobot = r;
        }

        @Override
        public void execute() {
            this.cleaningrobot.turnOn();
        }
}



