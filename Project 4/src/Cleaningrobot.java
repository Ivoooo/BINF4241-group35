import java.util.Scanner;


public class Cleaningrobot extends Thread {
    private int time = -1;
    private long timeStarted = -1;
    private boolean isRunning = false;
    private boolean isOn = false;
    private Scanner input = new Scanner(System.in);
    private int batteryStatus = 100;
    private boolean base = true;
    private int clean = 0;
    private boolean ready;

    public void setTimer() {
        if (this.isOn = true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("How long should the robot clean? ");
            time = scanner.nextInt();
            System.out.println("The robot will clean for "+time+" seconds");
        }
    }
    public void turnOn(){
        this.isOn = true;
        timeStarted = System.currentTimeMillis();
        while (isRunning == true){
            if (time == 0 ) this.returnBase();
        }

    }

    public void checkTimer() {
        long tmp = timeStarted + time - System.currentTimeMillis();
        if (this.isOn) {

            if (time != -1 && isRunning) System.out.println("Time remaining: " + tmp);

            else {
                System.out.println("Your last timer was" + this.time);
            }
        }
    }


    public void startClean(){
        if (this.batteryStatus == 100 && this.base == true){
            System.out.println("start clean");
            base = false;
            while(batteryStatus >= 0 && clean <= 100) {
                try {
                    sleep(100);
                    batteryStatus = batteryStatus - 5;
                    clean = clean + 5;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (clean == 100){
                    System.out.println("The robot is done cleaning");
                    returnBase();
                    clean = 0;
                    return;
                }
                if(batteryStatus == 0){
                    System.out.println("The robot has run out of battery, it will return to the base." );
                    returnBase();
                    ready = false;

                }
            }

        }
    }






    public void returnBase(){
        if (base == false){
            System.out.println("Back on Base");
            base = true;
            while(batteryStatus<100) {
                try {
                    sleep(100);
                    batteryStatus = batteryStatus + 1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            ready = true;
            System.out.println("The robot is ready to clean again.");

        }
    }


    public int checkBatteryStatus(){
        System.out.print("The batterystatus is: "+ batteryStatus);
        return batteryStatus;
    }

    public int checkCleaning(){
        System.out.println("The Cleaning is done "+ clean +" %");
        return clean;
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



}