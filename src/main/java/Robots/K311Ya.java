package Robots;

import Services.Cleanning;
import Services.Ordering;
import Services.Polishing;
import Services.Tasks;

public class K311Ya extends Robot implements Ordering, Cleanning, Polishing {

    private final static String MODEL = "Robots.K311Ya";
    private final static String SURFACE = "Floor/Furniture";
    private final static int COST = 5000;

    public K311Ya() {
        super(MODEL,SURFACE,COST);
    }


    @Override
    public boolean implementsInterface(Tasks task) {
        return task.toString().equalsIgnoreCase(Polishing.class.getSimpleName()) || task.toString().equalsIgnoreCase(Ordering.class.getSimpleName())
                || task.toString().equalsIgnoreCase(Cleanning.class.getSimpleName());
    }
}
