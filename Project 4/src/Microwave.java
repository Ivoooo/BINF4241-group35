import java.util.Scanner;

public class Microwave implements Runnable  {
   private int temperature = -1;
   private boolean isSwitchedOn = false;
   private long timeStarted = -1;
   private int time = -1;
   private boolean isRunning = false;
   int timesec;
   long tempsec;

   public void turnOn(){
       if(this.isSwitchedOn) {
           System.out.println("Microwave is already switched on");
           return;
       }
       this.isSwitchedOn = true;
       System.out.println("Microwave is now switched on.");
   }

    private void isStillRunning() {
        if(!this.isRunning) return;
        if(System.currentTimeMillis() > timeStarted + time) {
            this.isRunning = false;
            this.timeStarted = -1;
        }
    }


   public void setTimer() {
       isStillRunning();
       if (this.isSwitchedOn && !this.isRunning) {
           Scanner scanner = new Scanner(System.in);
           System.out.println("Enter the desired time to bake in seconds:");
           timesec = scanner.nextInt();
           this.time = timesec * 1000;
           System.out.println("Your desired time is " + timesec);
       }
       else if(isSwitchedOn) System.out.println("Microwave is currently running.");
       else System.out.println("Microwave is not switched on.");
   }

   public void setTemperature(){
       isStillRunning();
       if(this.isSwitchedOn && !this.isRunning) {
           Scanner scanner = new Scanner(System.in);
           System.out.println("Enter the desired temperature:");
           this.temperature = scanner.nextInt();
           System.out.println("The desired temperature is "+ this.temperature);
       }
       else if(isSwitchedOn) System.out.println("Microwave is currently running.");
       else System.out.println("Microwave is not switched on.");
   }

   public void startBaking(){
       isStillRunning();
       if(this.isSwitchedOn && !this.isRunning) {
           if (time > 0 && temperature > 0) {
               this.timeStarted = System.currentTimeMillis();
               this.isRunning = true;
               System.out.println("The microwave is baking now for " + time + " ms and at: " + temperature);
           }
           else {
               if(this.time <= 0) System.out.println("Please set a (positive) time.");
               if(this.temperature <= 0) System.out.println("Please set a (positive) temperature.");
           }
       }
       else if(this.isRunning) System.out.println("Microwave is running already.");
       else System.out.println("Microwave is not switched on.");
   }

   public void checkTimer() {
       isStillRunning();
       if (this.isSwitchedOn) {
           if (this.isRunning && this.time > 0) {
               long tmp = timeStarted + time - System.currentTimeMillis();

               tempsec = tmp/1000;
               System.out.println("Time remaining: " + tempsec);
           }
           else {
               if(this.time <= 0) System.out.println("Time hasn't been set");
               if(!this.isRunning) System.out.println("Isn't currently running.");
           }
       }
       else System.out.println("Sorry it's currently not switched on.");
   }

   public void stopBaking(){
       if(this.isSwitchedOn){
           this.isRunning = false;
           this.time = -1;
           this.timeStarted = -1;
           System.out.println("Microwave reset.");
       }
       else System.out.println("Currently not switched on.");
   }


   public void turnoff(){
       stopBaking();
       this.isSwitchedOn = false;
       System.out.println("Microwave is turned off");

   }

    @Override
    public void run() {
       if(this.time > 0 && !isRunning) {
           try {
               this.isRunning = true;
               this.timeStarted = System.currentTimeMillis();
               System.out.println("Microwave started");
               Thread.sleep(this.time);
               this.isRunning = false;
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }


}
