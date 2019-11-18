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
    }

    public void start() {
        this.run();
    }

    public void chooseProgram() {
        if(this.isSwitchedOn) {
            String program = input.next();
            if(program.equals("glasses")) this.time = 12000;
            else if(program.equals("plates")) this.time = 15000;
            else if(program.equals("pans")) this.time = 8000;
            else if(program.equals("mixed")) this.time = 20000;
            else this.time = 10000;
        }
    }

    public void checkTimer() {
        long tmp = timeStarted + time - System.currentTimeMillis();
        if(this.isSwitchedOn && time != -1) System.out.println("Time remaining: " + tmp);
    }

    public void stop() {
        if(this.isSwitchedOn) {
            if(this.running) {
                System.out.println("Sorry it's currently running");
                return;
            }
            this.time = -1;
        }
    }

    public void off() {
        //todo check if possible
        this.isSwitchedOn = false;
    }

    @Override
    public void run() {
        try {
            this.running = true;
            this.timeStarted = System.currentTimeMillis();
            Thread.sleep(time);
            this.running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
