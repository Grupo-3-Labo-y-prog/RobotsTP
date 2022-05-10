

public class K311Yfu extends Robot implements Cleanning,Polishing {
    private final static String MODEL = "K311Yfu";
    private final static String SURFACE = "Furniture";
    private final static int COST = 500;


    public K311Yfu() {
        super(MODEL,SURFACE,COST);
    }
    @Override
    public boolean implementsInterface(Tasks task) {
        return task.toString().equalsIgnoreCase(Polishing.class.getSimpleName())
                || task.toString().equalsIgnoreCase(Cleanning.class.getSimpleName());
    }
}
