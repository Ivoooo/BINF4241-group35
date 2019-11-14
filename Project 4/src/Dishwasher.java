/**
 * This class implements Runnable. That means that you need to
 * implement the run() method to describe the Thread behaviour.
 * Remember: runnable objects are not Threads, so using the
 * run() method on main process will not create a separate process.
 * */

public class Dishwasher implements Runnable{
    private boolean running;    // represent the state of the thread
    private int time = -1;           // represent the time of life of the thread
    private String program;

    public Dishwasher(){
        running = false;
    }

    /**
     * This method check if the thread is running
     * @return the state of the thread
     * */
    public boolean isRunning(){
        return running;
    }

    /**
     * This method contains the behaviour of the thread. Its implementation
     * is mandatory. In this case, the thread will sleep for the amount of time
     * specified in the constructor and handle the state of the Thread.
     * */
    @Override
    public void run() {
        try {
            running = true;
            Thread.sleep(time);
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setProgram(String program) {
        this.program = program;
        if(program.equals("glasses")) this.time = 12000;
        else if(program.equals("plates")) this.time = 15000;
        else if(program.equals("pans")) this.time = 8000;
        else if(program.equals("mixed")) this.time = 20000;
        else this.time = 10000;
    }

    public void checkTimer() {
       System.out.println("Remaining time: " + time );
    }
}
