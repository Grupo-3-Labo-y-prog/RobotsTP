package Robots;
import Services.Tasks;
import java.util.ArrayList;

public class P011H extends Robot{

    private final static String MODEL = "P011H";
    private final static String SURFACE = "Floor";
    private final static int COST = 1500;

    private ArrayList<Tasks> capableTasks = new ArrayList<>();


    public P011H() {
        super(MODEL, SURFACE, COST);
    }

    @Override
    public void setCapableTasks() {
        this.capableTasks.add(Tasks.CLEANNING);
        this.capableTasks.add(Tasks.POLISHING);
    }

    public ArrayList<Tasks> getCapableTasks() {
        return capableTasks;
    }

}
