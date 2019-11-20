import java.util.Scanner;

public class Dishwasher implements Runnable{
    private boolean switchedOn = false;
    private int time = -1;
    private long timeStarted = -1;
    private boolean running = false;

    public void on() {
        if(this.switchedOn) {
            System.out.println("Dishwasher is already switched on");
            return;
        }
        this.switchedOn = true;
        System.out.println("Dishwasher is now switched on.");
    }

    private void isStillRunning() {
        if(!this.running) return;
        if(System.currentTimeMillis() > timeStarted + time) {
            this.running = false;
            this.timeStarted = -1;
        }
    }

    public void start() {
        isStillRunning();
        if(this.time > 0 && !this.running) {
            this.running = true;
            this.timeStarted = System.currentTimeMillis();
            System.out.println("Dishwasher started.");
        }
        else {
            System.out.println("Sorry no program has been set.");
        }
    }

    public void chooseProgram() {
        isStillRunning();
        if(switchedOn && this.running) {
            System.out.println("Please choose a program: (f.e. glasses, plates, pans or mixed)");
            Scanner input = new Scanner(System.in);
            String program = input.next();
            if(program.equals("glasses")) this.time = 12000;
            else if(program.equals("plates")) this.time = 15000;
            else if(program.equals("pans")) this.time = 8000;
            else if(program.equals("mixed")) this.time = 20000;
            else this.time = 10000;
            System.out.println(program + ", set it will take: " + time + " milliseconds if started.");
        }
        else if(switchedOn) System.out.println("Dishwasher is currently running.");
        else System.out.println("Dishwasher is not switched on.");
    }

    public void checkTimer() {
        isStillRunning();
        if(this.switchedOn) {
            if (this.running && time != -1) {
                long tmp = timeStarted + time - System.currentTimeMillis();
                System.out.println("Time remaining: " + tmp);
            }
            else if(this.time != -1) {
                System.out.println("Time set but not running: " + this.time);
            }
            else System.out.println("No time has been set and not running.");
        }
        else System.out.println("Sorry it's currently not running.");
    }

    public void stop() {
        if(this.switchedOn) {
            this.running = false;
            this.time = -1;
            this.timeStarted = -1;
            System.out.println("Dishwasher reset.");
        }
    }

    public void off() {
        stop();
        this.switchedOn = false;
        System.out.println("Dishwasher is now off");
    }

    @Override
    public void run() {
        if(this.time > 0 && !running) {
            try {
                this.running = true;
                this.timeStarted = System.currentTimeMillis();
                System.out.println("Dishwasher started.");
                Thread.sleep(time);
                this.running = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Sorry no program has been set.");
        }
    }
}
