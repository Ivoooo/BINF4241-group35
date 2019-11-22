import java.util.*;
public class Smartphone {

    public String phoneCommand;
    private Command slot;

    private Scanner scanner = new Scanner(System.in);
    private int menuItem=0;
    private int menuItem2=0;
    private devices dev ;
    private boolean ovenON = false;
    private boolean microON = false;
    private boolean dishON  = false;
    private boolean wamaON = false;

    Oven oven = new Oven();
    Cleaningrobot robot = new Cleaningrobot();
    Microwave microwave = new Microwave();
    Dishwasher dish = new Dishwasher();
    WashingMachine wama = new WashingMachine();

    public Smartphone(){}

    public void menu() {
        System.out.println(" \nWhich Device would you like to control:\n " +
                "1. Oven \n" +
                "2. Microwave\n" +
                "3. Dishwasher\n" +
                "4. Washingmachine\n" +
                "5. Cleaningrobot\n");

        System.out.print("Choose menu item: ");
        menuItem = scanner.nextInt();
        if (menuItem == 1) {
                subMenuOven();
        }

         else if (menuItem == 2) {
                subMenuMicrowave();
         }
        else if (menuItem == 3) {
                subMenuDish();
        }
        else if (menuItem == 4) {
                subMenuWama();
        }
         else if (menuItem == 5) {
             subMenuRobot();
        }
    }

    public void subMenuOven(){
        while(true) {
            System.out.println(" \nWhat would you like to do:\n " +
                    "1. Switch on \n" +
                    "2. Set a timer\n" +
                    "3. Set a temperature\n" +
                    "4. set up program\n" +
                    "5. start cooking\n" +
                    "6. check Timer\n" +
                    "7. interrupt program\n" +
                    "8. Switch off\n" +
                    "9. Return to Main Menu\n");
            System.out.print("Choose menu item: ");
            menuItem2 = scanner.nextInt();
            if (menuItem2 == 1) {
                OventurnOn cmd = new OventurnOn(oven);
                setCommand(cmd);
                pressButton();
                ovenON = true;
            } else if (menuItem2 == 2 && ovenON == true) {
                OvensetTimer cmd = new OvensetTimer(oven);
                setCommand(cmd);
                pressButton();
            } else if (menuItem2 == 3 && ovenON == true) {
                OvensetTemperature cmd = new OvensetTemperature(oven);
                setCommand(cmd);
                pressButton();
            }else if(menuItem2 == 4 && ovenON == true){
                OvensetProgram cmd = new OvensetProgram(oven);
                setCommand(cmd);
                pressButton();
            } else if(menuItem2 == 5 && ovenON == true){
            OvenstartBaking cmd = new OvenstartBaking(oven);
            setCommand(cmd);
            pressButton();
            } else if(menuItem2 == 6 && ovenON == true){
                OvencheckTimer cmd = new OvencheckTimer(oven);
                setCommand(cmd);
                pressButton();
            } else if(menuItem2 == 7 && ovenON == true){
                OvenstopBaking cmd = new OvenstopBaking(oven);
                setCommand(cmd);
                pressButton();
            } else if(menuItem2 == 8 && ovenON == true){
                OventurnOff cmd = new OventurnOff(oven);
                setCommand(cmd);
                pressButton();
                ovenON = false;
            } else if (menuItem2 == 9) {
                menu();
                break;
            }
        }
    }

    public void subMenuMicrowave(){
        while(true) {

            System.out.println("\n What would you like to do:\n " +
                    "1. Switch on \n" +
                    "2. Set a timer\n" +
                    "3. Set a temperature\n" +
                    "4. start baking\n" +
                    "5. check Timer\n" +
                    "6. interrupt program\n" +
                    "7. Switch off\n" +
                    "8. Return to Main Menu\n");
            System.out.print("Choose menu item: ");
            menuItem2 = scanner.nextInt();
            if (menuItem2 == 1) {
                MicrowaveturnOn cmd = new MicrowaveturnOn(microwave);
                setCommand(cmd);
                pressButton();
                microON = true;
            } else if (menuItem2 == 2 && microON == true) {
                MicrowavesetTimer cmd = new MicrowavesetTimer(microwave);
                setCommand(cmd);
                pressButton();
            } else if (menuItem2 == 3 && microON == true) {
                MicrowavesetTemperature cmd = new MicrowavesetTemperature(microwave);
                setCommand(cmd);
                pressButton();
            } else if (menuItem2 == 4 && microON == true) {
                MicrowavestartBaking cmd = new MicrowavestartBaking(microwave);
                setCommand(cmd);
                pressButton();
            } else if (menuItem2 == 5 && microON == true) {
                MicrowavecheckTimer cmd = new MicrowavecheckTimer(microwave);
                setCommand(cmd);
                pressButton();
            } else if (menuItem2 == 6 && microON == true) {
                MicrowavestopBaking cmd = new MicrowavestopBaking(microwave);
                setCommand(cmd);
                pressButton();
            } else if (menuItem2 == 7 && microON == true) {
                MicrowaveturnOff cmd = new MicrowaveturnOff(microwave);
                setCommand(cmd);
                pressButton();
                microON = false;
            } else if (menuItem2 == 8) {
                menu();
                break;
            }
        }
    }

    public void subMenuDish(){
        while(true) {
            System.out.println(" \nWhat would you like to do:\n " +
                    "1. Switch on \n" +
                    "2. Start Dishwasher\n" +
                    "3. Choose Program\n" +
                    "4. Check Timer\n" +
                    "5. Stop Dishwasher\n" +
                    "6. Switch off\n" +
                    "7. Return to Main Menu\n");
            System.out.print("Choose menu item: ");
            menuItem2 = scanner.nextInt();
            if (menuItem2 == 1) {
                DishwasherSwitchOn cmd = new DishwasherSwitchOn(dish);
                setCommand(cmd);
                pressButton();
                dishON = true;

            } else if (menuItem2 == 2 && dishON == true) {
                DishwasherStart cmd = new DishwasherStart(dish);
                setCommand(cmd);
                pressButton();
            } else if (menuItem2 == 3 && dishON == true) {
                DishwasherChooseProgram cmd = new DishwasherChooseProgram(dish);
                setCommand(cmd);
                pressButton();
            } else if (menuItem2 == 4 && dishON == true) {
                DishwasherCheckTimer cmd = new DishwasherCheckTimer(dish);
                setCommand(cmd);
                pressButton();
            } else if (menuItem2 == 5 && dishON == true) {
                DishwasherStop cmd = new DishwasherStop(dish);
                setCommand(cmd);
                pressButton();
            } else if (menuItem2 == 6 && dishON == true) {
                DishwasherSwitchOff cmd = new DishwasherSwitchOff(dish);
                setCommand(cmd);
                pressButton();
                dishON = false;

            } else if (menuItem2 == 7) {
                menu();
                break;
            }
        }
    }

    public void subMenuWama(){
        while(true) {
            System.out.println("\n What would you like to do:\n " +
                    "1. Switch on \n" +
                    "2. Select Degrees\n" +
                    "3. Choose Program\n" +
                    "4. Turn off\n" +
                    "5. Switch off\n" +
                    "6. Return to Main Menu\n");

            System.out.print("Choose menu item: ");
            menuItem2 = scanner.nextInt();
            if (menuItem2 == 1) {
                WashingMachineOn cmd = new WashingMachineOn(wama);
                setCommand(cmd);
                pressButton();
                wamaON = true;

            } else if (menuItem2 == 2 && wamaON == true) {
                WashingMachineSetTemperature cmd = new WashingMachineSetTemperature(wama);
                setCommand(cmd);
                pressButton();
            } else if (menuItem2 == 3 && wamaON == true) {
                WashingMachineChooseProgram cmd = new WashingMachineChooseProgram(wama);
                setCommand(cmd);
                pressButton();
            } else if (menuItem2 == 4 && wamaON == true) {
                WashingMachineStop cmd = new WashingMachineStop(wama);
                setCommand(cmd);
                pressButton();
            } else if (menuItem2 == 5 && wamaON == true) {
                WashingMachineOff cmd = new WashingMachineOff(wama);
                setCommand(cmd);
                pressButton();

            } else if (menuItem2 == 6) {
                menu();
                break;
            }
        }
    }


    public void subMenuRobot() {
       while(true){
        System.out.println(" \nWhat would you like to do:\n " +
                "1. Set a timer\n" +
                "2. Start Cleaning\n" +
                "3. Check Timer \n" +
                "4. Check Battery Status\n" +
                "5. Check Cleaning Progress\n" +
                "6. Return to Base\n"+
                "7. Return to Main Menu\n");

        System.out.print("Choose menu item: ");
        menuItem2 = scanner.nextInt();
        if (menuItem2 == 1) {
            RobotSetTimer cmd = new RobotSetTimer(robot);
            setCommand(cmd);
            pressButton();
        } else if (menuItem2 == 2) {
            RoboStartClean cmd = new RoboStartClean(robot);
            setCommand(cmd);
            pressButton();
        } else if (menuItem2 == 3) {
            RobotCheckTimer cmd = new RobotCheckTimer(robot);
            setCommand(cmd);
            pressButton();
        } else if (menuItem2 == 4) {
            RobotCheckBatterystatus cmd = new RobotCheckBatterystatus(robot);
            setCommand(cmd);
            pressButton();
        } else if (menuItem2 == 5) {
            RobotCheckCleaningProgress cmd = new RobotCheckCleaningProgress(robot);
            setCommand(cmd);
            pressButton();
        } else if (menuItem2 == 6) {
            CleaningrobotReturnBase cmd = new CleaningrobotReturnBase(robot);
            setCommand(cmd);
            pressButton();
        } else if (menuItem2 == 7) {
            menu();
            break;
        }
        }
    }


    public void setCommand(Command c){
        slot = c;
    }
    public void pressButton(){
        slot.execute();
    }
}
