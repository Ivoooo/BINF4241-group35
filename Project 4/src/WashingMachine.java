import java.util.InputMismatchException;
import java.util.Scanner;

public class WashingMachine implements Runnable{
    private boolean switchedOn = false;
    private int time = -1;
    private long timeStarted = -1;
    private boolean running = false;
    private int temperature = -1;

    public void on() {
        if(this.switchedOn) {
            System.out.println("Washing machine is already switched on");
            return;
        }
        this.switchedOn = true;
        System.out.println("The washing machine is now switched on.");
    }

    private void isStillRunning() {
        if(!this.running) return;
        if(System.currentTimeMillis() > timeStarted + time) {
            this.running = false;
            this.timeStarted = -1;
        }
    }

    public void setTemperature() {
        if(this.switchedOn && !this.running) {
            System.out.print("What temperature would you like?");
            Scanner input = new Scanner(System.in);
            try {
                this.temperature = input.nextInt();
            }
            catch (InputMismatchException a) {
                System.out.print("Please enter a number.");
                this.temperature = -1;
            }
        }
        else if(!this.switchedOn) System.out.println("You need to switch the washing machine on first.");
        else System.out.println("WashingMachine is currently running.");
    }

    public void chooseProgram() {
        isStillRunning();
        if(switchedOn && !this.running && this.temperature > 0) {
            System.out.println("Please choose a program: (f.e. double rinse, intense, quick, spin)");
            Scanner input = new Scanner(System.in);
            String program = input.next();
            if(program.equals("double rinse")) this.time = 12000;
            else if(program.equals("intense")) this.time = 15000;
            else if(program.equals("quick")) this.time = 8000;
            else if(program.equals("spin")) this.time = 20000;
            else this.time = 10000;

            this.running = true;
            this.timeStarted = System.currentTimeMillis();
            System.out.println(program + " set it will take: " + time + " milliseconds.");
        }
        else if(this.running) System.out.println("Dishwasher is running already.");
        else if(!this.switchedOn) System.out.println("Dishwasher is not switched on.");
        else System.out.println("You haven't set a temperature.");
    }

    public void checkTimer() {
        isStillRunning();
        if(this.switchedOn) {
            if (this.running && time > 0) {
                long tmp = timeStarted + time - System.currentTimeMillis();
                System.out.println("Time remaining : " + tmp);
            }
            else {
                if(this.temperature <= 0) System.out.println("Temperature hasn't been set.");
                if(!this.running) System.out.println("Isn't currently running.");
            }
        }
        else System.out.println("Sorry it's currently not switched on.");
    }

    public void stop() {
        if(this.switchedOn && !this.running) {
            this.time = -1;
            this.timeStarted = -1;
            this.temperature = -1;
            System.out.println("Washing machine reset.");
        }
        else if(this.running) System.out.print("Sorry, it's currently running.");
        else System.out.println("Currently not switched on.");
    }

    public void off() {
        stop();
        this.switchedOn = false;
        System.out.println("Washing machine is now off");
    }

    @Override
    public void run() {
        if(this.time > 0 && !running) {
            try {
                this.running = true;
                this.timeStarted = System.currentTimeMillis();
                System.out.println("Washing machine started.");
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
