public class GraveSingleton {

    private static GraveSingleton uniqueInstance;
    private Figure[] grave = new Figure[32];
    private GraveSingleton(){}

    public static GraveSingleton getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new GraveSingleton();
        }
        return uniqueInstance;
    }

    public void addGrave(Figure a) {
        int i = 0;
        while(grave[i] != null) ++i;
        grave[i] = a;
    }

}
