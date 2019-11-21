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
    int second;

    public void setTimer() {
        isStillRunning();
        if (this.isOn = true && !this.isRunning) {
            System.out.println("How long should the robot clean? ");
            Scanner scanner = new Scanner(System.in);
            second = scanner.nextInt();
            this.time = second * 1000;
            System.out.println("The robot will clean for " + second + " seconds");

            this.isRunning = true;
        }
        else if(isOn) System.out.println("The robot is cleaning");
        else System.out.println("the robot is not cleaning");
      }



    private void isStillRunning() {
        if(!this.isRunning) return;
        if(System.currentTimeMillis() > timeStarted + time) {
            this.isRunning = false;
            this.timeStarted = -1;
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
        isStillRunning();
        if (this.isOn) {
            if( this.isRunning && this.time > 0  ) {
                long tmp = timeStarted + time - System.currentTimeMillis();
                System.out.println("Time remaining: " + tmp);
            }
            else {
                if(this.time <= 0) System.out.println("Time hasn't been set");
                if(!this.isRunning) System.out.println("Isn't currently running.");

            }
        }
        else System.out.println("Your last timer was" + this.time);
    }


    public void startClean(){
       // isStillRunning();
        if (this.batteryStatus == 100 && this.base == true && this.isRunning){
            System.out.println("start clean");
            base = false;
            while(batteryStatus >= 0 && clean <= 100) {
                this.timeStarted = System.currentTimeMillis();
                while(System.currentTimeMillis() < this.timeStarted+this.time ){
                    batteryStatus = batteryStatus -5;
                    clean = clean + 2 ;
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
        else if(this.batteryStatus < 100) System.out.println("Battery not full yet");
        else if(this.base == false) System.out.println("Robot is already cleaning");
        else if(!this.isRunning) System.out.println("Set Timer first. ");
    }






    public void returnBase(){
        if (base == false){
            System.out.println("Back on Base");
            base = true;
            while(batteryStatus<100) {
                this.timeStarted = System.currentTimeMillis();
                while (System.currentTimeMillis() < this.timeStarted + 100) {
                    batteryStatus = batteryStatus + 2;

                }


                ready = true;
                System.out.println("The robot is ready to clean again.");
            }
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