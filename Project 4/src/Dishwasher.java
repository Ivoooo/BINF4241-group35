import java.util.Scanner;

/**
 * This class implements Runnable. That means that you need to
 * implement the run() method to describe the Thread behaviour.
 * Remember: runnable objects are not Threads, so using the
 * run() method on main process will not create a separate process.
 * */

public class Dishwasher implements Runnable{
    private boolean isSwitchedOn = false;
    private int time = -1;
    private long timeStarted = -1;
    private boolean running = false;
    private Scanner input = new Scanner(System.in);

    public void on() {
        this.isSwitchedOn = true;
        System.out.println("Dishwasher is now running.");
    }

    public void start() {
        this.run();
    }

    public void chooseProgram() {
        if(this.isSwitchedOn) {
            System.out.println("Please choose a program: (f.e. glasses, plates, pans or mixed)");
            String program = input.next();
            if(program.equals("glasses")) this.time = 12000;
            else if(program.equals("plates")) this.time = 15000;
            else if(program.equals("pans")) this.time = 8000;
            else if(program.equals("mixed")) this.time = 20000;
            else this.time = 10000;
            System.out.println(program + ", set it will take: " + time + " milliseconds if started.");
        }
    }

    public void checkTimer() {
        if(this.isSwitchedOn) {
            if (this.running && time != -1) {
                long tmp = timeStarted + time - System.currentTimeMillis();
                System.out.println("Time remaining: " + tmp);
            }
            else if(this.time != -1) {
                System.out.println("Time set but not running: " + this.time);
            }
            else System.out.println("No time has been set.");
        }
        else System.out.println("Sorry it's currently not running.");
    }

    public void stop() {
        if(this.isSwitchedOn) {
            this.running = false;
            this.time = -1;
            this.timeStarted = -1;
            System.out.println("Dishwasher reset.");
        }
    }

    public void off() {
        //todo check if possible
        this.isSwitchedOn = false;
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
