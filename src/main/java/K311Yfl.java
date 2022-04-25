
public class K311Yfl extends Robot implements Cleanning {
    private final static String MODEL = "K311Y-fl";
    private final static String SURFACE = "Floor";
    private final static int COST = 1000;


    public K311Yfl() {
        super(MODEL, SURFACE, COST);
    }

    public boolean implementsInterface(Tasks task) {
        return task.toString().equalsIgnoreCase(Cleanning.class.getSimpleName()) ;
    }
}
