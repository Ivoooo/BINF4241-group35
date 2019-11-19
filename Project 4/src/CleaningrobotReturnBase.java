public class CleaningrobotReturnBase implements Command {
    Cleaningrobot cleaningrobot;
    public CleaningrobotReturnBase(Cleaningrobot r) {
            this.cleaningrobot = r;
        }

        @Override
        public void execute() {
            this.cleaningrobot.returnBase();
        }
}



