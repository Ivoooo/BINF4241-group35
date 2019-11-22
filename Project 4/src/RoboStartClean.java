public class RoboStartClean implements Command {
    private Cleaningrobot cleaningrobot;
    public RoboStartClean(Cleaningrobot r) {
         this.cleaningrobot = r;
    }

    @Override
        public void execute() {
            this.cleaningrobot.startClean();
        }
}

