package Robots;
import Services.Tasks;

import java.util.ArrayList;

public class S031RTY extends Robot{

    private final static String MODEL = "S031RTY";
    private final static String SURFACE = "N/A";
    private final static int COST = 2700;

    private ArrayList<Tasks> capableTasks = new ArrayList<>();

    public S031RTY() {
        super(MODEL,SURFACE,COST);
    }

    @Override
    public void setCapableTasks() {
        this.capableTasks.add(Tasks.ORDERING);
    }

    public ArrayList<Tasks> getCapableTasks() {
        return capableTasks;
    }

}
