public class RoboStartClean implements Command {
    Cleaningrobot cleaningrobot;
    public RoboStartClean(Cleaningrobot r) {
         this.cleaningrobot = r;
    }

    @Override
        public void execute() {
            this.cleaningrobot.startClean();
        }
}

