import java.util.*;
public class Smartphone {

    Command slot;
    Scanner scanner = new Scanner(System.in);
    int menuItem=0;
    int menuItem2=0;
    devices dev ;
    boolean ovenON = false;
    boolean microON = false;
    boolean dishON  = false;

    Oven oven = new Oven();
    Cleaningrobot robot = new Cleaningrobot();
    Microwave microwave = new Microwave();
    Dishwasher dish = new Dishwasher();

    public Smartphone(){}

    public void menu() {
        System.out.println(" Which Device would you like to control:\n " +
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
                //subMenuWama();
            System.out.println("Here should be the Washingmachine");
        }
         else if (menuItem == 5) {
             subMenuRobot();
        }
    }

    public void subMenuOven(){
        while(true) {
            System.out.println("oven");
            System.out.println(" What would you like to do:\n " +
                    "1. Switch on \n" +
                    "2. Set a timer\n" +
                    "3. Set a temperature\n" +
                    "4. set up program\n" +
                    "5. start cooking\n" +
                    "6. check Timer\n" +
                    "7. interrupt program\n" +
                    "8. Switch off\n" +
                    "9. Return to Main Menu");
            System.out.print("Choose menu item: ");
            menuItem2 = scanner.nextInt();
            if (menuItem2 == 1) {
                System.out.println("switch on Oven");
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
                OvenstartBaking cmd = new OvenstartBaking(oven);
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
            System.out.println("Microwave");
            System.out.println(" What would you like to do:\n " +
                    "1. Switch on \n" +
                    "2. Set a timer\n" +
                    "3. Set a temperature\n" +
                    "4. start baking\n" +
                    "5. check Timer\n" +
                    "6. interrupt program\n" +
                    "7. Switch off\n" +
                    "8. Return to Main Menu");
            System.out.print("Choose menu item: ");
            menuItem2 = scanner.nextInt();
            if (menuItem2 == 1) {
                dev = devices.OVEN;
                System.out.println("switch on Microwave");
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
            System.out.println("Dishwasher");
            System.out.println(" What would you like to do:\n " +
                    "1. Switch on \n" +
                    "2. Start Dishwasher\n" +
                    "3. Choose Program\n" +
                    "4. Check Timer\n" +
                    "5. Stop Dishwasher\n" +
                    "6. Switch off\n" +
                    "7. Return to Main Menu");
            System.out.print("Choose menu item: ");
            menuItem2 = scanner.nextInt();
            if (menuItem2 == 1) {
                System.out.println("switch on Microwave");
                dishON = true;
            } else if (menuItem2 == 2 && dishON == true) {
                DishwasherSwitchOn cmd = new DishwasherSwitchOn(dish);
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


    public void subMenuRobot() {
       while(true){
        System.out.println("robo");
        System.out.println(" What would you like to do:\n " +
                "1. Set a timer\n" +
                "2. Start Cleaning\n" +
                "3. Check Timer \n" +
                "4. Check Battery Status\n" +
                "5. Check Cleaning Progress\n" +
                "6. Return to Base\n"+
                "7. Return to Main Menu");

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
