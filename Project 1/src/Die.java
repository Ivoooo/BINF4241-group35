public class Die {
    public int rollDie(){
        double randomnumber = (Math.random() * ((6 - 1) + 1)) + 1;
        return (int) randomnumber;
    }
}
