
public class S031RTY extends Robot implements Ordering {

    private final static String MODEL = "S031RTY";
    private final static String SURFACE = "N/A";
    private final static int COST = 2700;

    public S031RTY() {
        super(MODEL,SURFACE,COST);
    }

    @Override
    public boolean implementsInterface(Tasks task) {
        return task.toString().equalsIgnoreCase(Ordering.class.getSimpleName()) ;

    }
}
