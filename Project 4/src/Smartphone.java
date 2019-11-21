import java.util.*;
public class Smartphone {
    public String phoneCommand;
    private Command slot;
    Scanner scanner = new Scanner(System.in);
    int menuItem=0;
    int menuItem2=0;
    devices dev ;

    public Smartphone(){}

    public devices menu() {
        System.out.println(" Which Device would you like to control:\n " +
                "1. Oven \n" +
                "2. Microwave\n" +
                "3. Dishwasher\n" +
                "4. Washingmachine\n" +
                "5. Cleaningrobot\n");

        System.out.print("Choose menu item: ");
        menuItem = scanner.nextInt();
        if (menuItem == 1) {
                System.out.println("oven");
            System.out.println(" What would you like to do:\n " +
                    "1. Switch on \n" +
                    "2. Set a timer\n" +
                    "3. Set a temperature\n" +
                    "4. set up program\n" +
                    "5. start cooking\n" +
                    "6. check Timer\n" +
                    "7. interrupt program\n" +
                    "8. Switch off");
                System.out.print("Choose menu item: ");
                menuItem2 = scanner.nextInt();
                if(menuItem2 == 1 ){
                    //todo command to start thread?
                    dev = devices.OVEN;
                    System.out.println("switch on Oven");
                    return dev;
                }

        }
         else if (menuItem == 2) {
            System.out.println("micro");
        }
        else if (menuItem == 3) {

            System.out.println("dish");
        }
        else if (menuItem == 4) {
            System.out.println("wama");
        }
         else if (menuItem == 2) {
                System.out.println("robo");
        }
    return dev;
    }










    public void setCommand(Command c){
        slot = c;
    }
    public void pressButton(){
        slot.execute();
    }
}
