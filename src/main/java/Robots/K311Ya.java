package Robots;
import Services.Tasks;
import java.util.ArrayList;

public class K311Ya extends Robot{

    private final static String MODEL = "K311Ya";
    private final static String SURFACE = "Floor/Furniture";
    private final static int COST = 5000;

    private ArrayList<Tasks> capableTasks = new ArrayList<>();

    public K311Ya() {
        super(MODEL,SURFACE,COST);
    }

    @Override
    public void setCapableTasks() {
        this.capableTasks.add(Tasks.CLEANNING);
        this.capableTasks.add(Tasks.ORDERING);
        this.capableTasks.add(Tasks.POLISHING);
    }

    public ArrayList<Tasks> getCapableTasks() {
        return capableTasks;
    }

}
