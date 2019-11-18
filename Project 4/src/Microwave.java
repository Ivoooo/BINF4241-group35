import java.util.Scanner;
public class Microwave  {

   private MyThread myThread;
   private int temperature = -1;

   public void setTimer() {
       if (myThread.isRunning()) {
           Scanner scanner = new Scanner(System.in);
           System.out.println("Enter the desired time to bake:");
           myThread.time = scanner.nextInt();
       }
   }
   public void setTemperature(){
    if(myThread.isRunning()) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value:");
        temperature = scanner.nextInt();
        }
   }
   public void startBaking(){
       if(myThread.time != -1 && temperature != -1 ){
           myThread.run();
       }
       else{
           System.out.println("Set first the timer and the temperature");
       }
   }
   public void checkTimer(){
       


   }
   public void stopBaking(){
       //only if startBaking is already executed
   }
   public void turnoff(){

   }


}
