import java.util.Scanner;
public class Oven {
    private int temperature = -1;
    private boolean isSwitchedOn = false;
    private long timeStarted = -1;
    private int time = -1;
    private boolean isRunning = false;
    private String program;

    public void turnon(){
        isSwitchedOn = true;
        System.out.println("Oven is turned on");
    }
    public void setTimer() {
        if (this.isSwitchedOn = true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the desired time to bake in seconds:");
            time = scanner.nextInt();
            System.out.println("Your desired time is"+time);
        }
    }
    public void setTemperature(){
        if(this.isSwitchedOn = true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the value:");
            temperature = scanner.nextInt();
            System.out.println("The desired temperature is"+temperature);
        }
    }
    public void setProgram(){
        if(this.isSwitchedOn = true){
            System.out.println("Select a program (e.g. ventilated, grill, etc.");
            Scanner scanner = new Scanner(System.in);
            program = scanner.next();
            System.out.println("Your chosen program is:"+program);

        }
    }
    public void startBaking(){
        if(this.isSwitchedOn) {
            if (time != -1 && temperature != -1 && program != null) {
                this.run();
                System.out.println("The oven is baking now");
            } else {
                System.out.println("Set first the timer, the temperature and the program");
            }
        }
    }
    public void run() {
        try {
            isRunning = true;
            Thread.sleep(time);
            isRunning = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void checkTimer() {
        long tmp = timeStarted + time - System.currentTimeMillis();
        if (this.isSwitchedOn) {

            if (time != -1 && isRunning) System.out.println("Time remaining: " + tmp);

            else {
                System.out.println("Your last timer was" + this.time);
            }
        }
    }
    public void stopBaking(){
        if(this.isSwitchedOn){
            if(this.isRunning = true){
                this.isRunning = false;
                System.out.println("You stopped baking");
            }
        }
    }
    public void turnoff(){
        isSwitchedOn = false;
        System.out.println("Oven is turned off");
    }


}
