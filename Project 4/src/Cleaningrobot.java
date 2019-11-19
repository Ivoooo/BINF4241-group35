import java.util.Scanner;


public class Cleaningrobot extends Thread {
    private int time = -1;
    private boolean running = false;
    private Scanner input = new Scanner(System.in);
    private int batteryStatus = 100;
    private boolean base = true;
    private int clean = 0;
    private boolean ready;



    public void startClean(){
        if (this.batteryStatus == 100 && this.base == true){
            System.out.println("start clean");
            base = false;
            while(batteryStatus >= 0 && clean <= 20) {
                try {
                    sleep(100);
                    batteryStatus = batteryStatus - 3;
                    clean = clean + 1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (clean == 20){
                    System.out.println("The robot is done cleaning");
                    this.returnBase();
                    clean = 0;
                }
                if(batteryStatus == 0){
                    System.out.println("The robot has run out of battery, it will return to the base.");
                    this.returnBase();
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
                    sleep(500);
                    batteryStatus = batteryStatus + 1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            ready = true;
            System.out.println("The robot is ready to clean again.");

        }
    }

    public boolean onBase(){
        return base;
    }

    public int checkBatteryStatus(){
        return batteryStatus;
    }
}