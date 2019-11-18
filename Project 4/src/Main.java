/**
 * This is a test class. Basically, two threads can be created by the user. The first thread always wait 10 seconds,
 * the second one 20. This class also provide and example of how manage the time without a thread but with the
 * default java method System.currentTimeMillis(). This method returns the current timestamp of the System in
 * millisecond as a long output.
 * */

import java.util.*;

public class Main {

    public static void main(String args[]){

        MyThread mt1 = new MyThread(20000);                         // Behaviour of Thread 1
        MyThread mt2 = new MyThread(20000);         // Behaviour of Thread 2
        MyThread mt3 = new MyThread(20000);
        MyThread mt4 = new MyThread(20000);
        MyThread mt5 = new MyThread(20000);
        Thread rt1;
        Thread rt2;
        Thread rt3;
        Thread rt4;
        Thread rt5;

        long elapsed1 = System.currentTimeMillis();     // Pointer to current time for Thread 1
        long elapsed2 = System.currentTimeMillis();
        long elapsed3 = System.currentTimeMillis();
        long elapsed4 = System.currentTimeMillis();
        long elapsed5 = System.currentTimeMillis();


        Microwave a = new Microwave();
        Smartphone phone = new Smartphone();

        MicrowavecheckTimer cmd2 = new MicrowavecheckTimer(a);
        phone.setCommand(cmd2);
        phone.pressButton();

        MicrowaveturnOn cmd = new MicrowaveturnOn(a);
        phone.setCommand(cmd);
        phone.pressButton();

        phone.setCommand(cmd2);
        phone.pressButton();

        MicrowavesetTemperature cmd1 = new MicrowavesetTemperature(a);
        phone.setCommand(cmd1);
        phone.pressButton();

        Thread b = new Thread(a,"Microwave");
        b.start();

        Scanner input = new Scanner(System.in);
        String i = input.next();
        phone.setCommand(cmd2);
        phone.pressButton();


        while(true){

            // Collecting User Input in an infinite loop
            System.out.println("Which Device do you wan't to start?");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();

            // Basic control for command

            // command = 1 -> start the Thread 1
            if (command.equals("Oven") && !mt1.isRunning()) {
                rt1 = new Thread(mt1, "FirstThread");           // Creation of the Thread 1 assigning
                elapsed1 = System.currentTimeMillis();                // update of the pointer to current timestamp
                rt1.start();
            }

            // command = 2 -> start the Thread 2
            else if (command.equals("Microwave") && !mt2.isRunning()){
                rt2 = new Thread(mt2, "SecondThread");          // Creation of the Thread 1 assigning
                elapsed2 = System.currentTimeMillis();                // update of the pointer to current timestamp
                rt2.start();
            }
            else if (command.equals("Dishwasher") && !mt3.isRunning()){
                rt3 = new Thread(mt3, "thirdThread");
                elapsed3 = System.currentTimeMillis();
                rt3.start();
            }
            else if (command.equals("Washing Machine") && !mt4.isRunning()){
                rt4 = new Thread(mt4, "fourthThread");
                elapsed4 = System.currentTimeMillis();
                rt4.start();
            }
            else if (command.equals("Cleaning robot") && !mt5.isRunning()){
                rt5 = new Thread(mt5, "fifthThread");
                elapsed5 = System.currentTimeMillis();
                rt5.start();
            }


            // command = stop 1 -> stop of Thread 1
            else if (command.equals("stop Oven") && mt1.isRunning()) {
                /*
                 * deleting the behaviour to destroy the hidden state of variables. If the thread is stopped before his
                 * natural death, the variable running will be true. You can also create a method stop() in the
                 * runnable object that change the state to false and call it instead of destroying the runnable
                 * object.
                 * */
                mt1 = null;
                rt1 = null;
                float time = System.currentTimeMillis() - elapsed1;     // Calculation of elapsed time: (end - start)
                System.out.println("Elapsed time 1: " + time);
                mt1 = new MyThread();                           // recreation of the deleted behaviour objects
                rt1 = new Thread(mt1, "theThread");      // recreation of deleted thread
            }

            // command = stop 2 -> stop of Thread 2 (same as before but for Thread 2)
            else if (command.equals("stop Microwave") && mt2.isRunning()) {
                mt2 = null;
                rt2 = null;
                float time = System.currentTimeMillis() - elapsed2;
                System.out.println("Elapsed time 2: " + time);
                mt2 = new MyThread();
                rt2 = new Thread(mt1, "theThread");

            }
            else if (command.equals("stop Dishwasher") && mt3.isRunning()) {
                mt3 = null;
                rt3 = null;
                float time = System.currentTimeMillis() - elapsed3;
                System.out.println("Elapsed time 3: " + time);
                mt3 = new MyThread();
                rt3 = new Thread(mt1, "theThread");

            }
            else if (command.equals("stop Washing Machine") && mt4.isRunning()) {
                mt4 = null;
                rt4 = null;
                float time = System.currentTimeMillis() - elapsed4;
                System.out.println("Elapsed time 4: " + time);
                mt4 = new MyThread();
                rt4 = new Thread(mt1, "theThread");

            }
            else if (command.equals("stop Cleaning robot") && mt5.isRunning()) {
                mt5 = null;
                rt5 = null;
                float time = System.currentTimeMillis() - elapsed5;
                System.out.println("Elapsed time 5: " + time);
                mt5 = new MyThread();
                rt5 = new Thread(mt1, "theThread");

            }
            // unknown command -> the program check the state of the Threads
            else {

                // The check is done on the runnable objects variables cause they can be managed by the developer
                if (mt1.isRunning()){
                    System.out.println("Thread 1 is running");
                }

                if (mt2.isRunning()){
                    System.out.println("Thread 2 is running");
                }
                if(mt3.isRunning()){
                    System.out.println("Thread 3 is running");
                }
                if(mt4.isRunning()) {
                    System.out.println("Thread 4 is running");
                }
                if(mt5.isRunning()) {
                    System.out.println("Thread 5 is running");
                }
            }
        }

    }
}