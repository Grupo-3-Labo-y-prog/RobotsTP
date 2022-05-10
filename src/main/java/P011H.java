

public class P011H extends Robot implements Cleanning,Polishing {

    private final static String MODEL = "P011H";
    private final static String SURFACE = "Floor";
    private final static int COST = 1500;


    public P011H() {
        super(MODEL, SURFACE, COST);
    }


    @Override
    public boolean implementsInterface(Tasks task) {
        return task.toString().equalsIgnoreCase(Cleanning.class.getSimpleName())
                || task.toString().equalsIgnoreCase(Polishing.class.getSimpleName());
    }
}
