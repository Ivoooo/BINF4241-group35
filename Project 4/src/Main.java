/**
 * This is a test class. Basically, two threads can be created by the user. The first thread always wait 10 seconds,
 * the second one 20. This class also provide and example of how manage the time without a thread but with the
 * default java method System.currentTimeMillis(). This method returns the current timestamp of the System in
 * millisecond as a long output.
 * */

import java.util.*;

public class Main {

    public static void main(String args[]){

        MyThread mt1 = new Dishwasher();                         // Behaviour of Thread 1
        MyThread mt2 = new MyThread(20000);         // Behaviour of Thread 2

        Thread rt1;         // Thread 1
        Thread rt2;         // Thread 2

        long elapsed1 = System.currentTimeMillis();     // Pointer to current time for Thread 1
        long elapsed2 = System.currentTimeMillis();     // Pointer to current time for Thread 2

        while(true){

            // Collecting User Input in an infinite loop
            System.out.println("Which Thread do you wonna start?");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();

            // Basic control for command

            // command = 1 -> start the Thread 1
            if (command.equals("1") && !mt1.isRunning()) {
                rt1 = new Thread(mt1, "FirstThread");           // Creation of the Thread 1 assigning
                elapsed1 = System.currentTimeMillis();                // update of the pointer to current timestamp
                rt1.start();
            }

            // command = 2 -> start the Thread 2
            else if (command.equals("2") && !mt2.isRunning()){
                rt2 = new Thread(mt2, "SecondThread");          // Creation of the Thread 1 assigning
                elapsed2 = System.currentTimeMillis();                // update of the pointer to current timestamp
                rt2.start();
            }

            // command = stop 1 -> stop of Thread 1
            else if (command.equals("stop 1") && mt1.isRunning()) {
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
            else if (command.equals("stop 2") && mt2.isRunning()) {
                mt2 = null;
                rt2 = null;
                float time = System.currentTimeMillis() - elapsed2;
                System.out.println("Elapsed time 2: " + time);
                mt2 = new MyThread();
                rt2 = new Thread(mt1, "theThread");

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
            }
        }

    }
}