import java.util.Scanner;
public class Microwave extends MyThread implements Command {
    private String state;
   public void request(String l){
        this.state = l;
    }
   private MyThread myThread;

   public void setTimer(){}
   public int setTemperature(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the value:");
       return scanner.nextInt();
   }
   public void startBaking(){}
   public int checkTimer(){
       return myThread.getThreadtime();
   }
   public void stopBaking(){
       //only if startBaking is already executed
   }
   public void turnoff(){

   }
   public void execute(){
        //if "state" = settimer -> state.setTimer()

    }

}
