package Robots;

import Services.Cleanning;
import Services.Polishing;
import Services.Tasks;

public class P011H extends Robot implements Cleanning, Polishing {

    private final static String MODEL = "Robots.P011H";
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
