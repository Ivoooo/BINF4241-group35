import java.util.Scanner;


public class Cleaningrobot extends Thread {
    private long time = -1;
    private long timeStarted = -1;
    private boolean isRunning = false;
    private int batteryStatus = 100;
    private boolean base = true;
    private int toClean = 100;


    public void setTimer() {
        isStillRunning();
        if (!this.isRunning) {
            System.out.println("How long should the robot clean? (in seconds) ");
            Scanner scanner = new Scanner(System.in);
            int second = scanner.nextInt();
            this.time = second * 1000;
            System.out.println("The robot will clean for " + second + " seconds");

            this.isRunning = true;
        }
        else System.out.println("the robot is busy cleaning.");
      }


    private void isStillRunning() {
        if(!this.isRunning) return;

        long x = System.currentTimeMillis() - this.timeStarted;

        long increments = 100; //every 100 milliseconds is one cleaning/charging cycle
        for(long i = 0; i < x; i += increments) {
            if(this.toClean <= 0 && !this.base) {
                this.toClean = 0;
                this.base = true;
                this.isRunning = false;
                System.out.println("Everything has been cleaned.");
                return;
            }

            else if(System.currentTimeMillis() > this.time + this.timeStarted) {
                System.out.println("The program is finished (timer is done)");
                System.out.println(this.toClean + "% is left to clean and battery is at: " + this.batteryStatus);
                this.base = true;
                this.timeStarted = -1;
                return;
            }

            else if(this.batteryStatus < 100 && this.base) {
                this.batteryStatus += 5;
                if (this.batteryStatus >= 100) {
                    this.batteryStatus = 100;
                    System.out.println("The robot has finished charging.");
                }
            }

            //clean:
            else {
                if(this.base) {
                    this.base = false;
                    System.out.println("The robot is now cleaning the rest.");
                }

                this.batteryStatus -= 2;
                if(this.batteryStatus <= 0) {
                    this.batteryStatus = 0;
                    this.base = true;
                    System.out.println("The robot has gone back to the charging base.");
                }
                else {
                    this.toClean -= 3;
                    this.time -= increments;
                    this.timeStarted += increments;
                }
            }
        }
    }


    public void checkTimer() {
        isStillRunning();
        if (this.isRunning) {
            long tmp = timeStarted + time - System.currentTimeMillis();
            System.out.println("Time remaining: " + tmp);
        }
        else System.out.println("The robot is in base currently");
    }


    public void startClean(){
        isStillRunning();
        if (this.batteryStatus == 100 && !this.isRunning && this.time > 0){
            if(this.toClean <= 0) {
                System.out.println("Your room was completely clean so now it's completely dirty again.");
                this.toClean = 100;
            }

            System.out.println("start cleaning");
            this.base = false;
            this.timeStarted = System.currentTimeMillis();
        }
        else if(this.batteryStatus < 100 && !this.isRunning) System.out.println("Is charging");
        else if(this.isRunning) System.out.println("Is already cleaning");
        else if(this.time <= 0) System.out.println("Set a time");
    }


    public void checkBatteryStatus(){
        isStillRunning();
        System.out.print("The battery status is: "+ this.batteryStatus);
    }

    public void checkCleaning(){
        isStillRunning();
        System.out.println("The robot has "+ this.toClean +" % left to clean");
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