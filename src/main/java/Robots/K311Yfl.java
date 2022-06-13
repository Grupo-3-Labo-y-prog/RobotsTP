package Robots;
import Services.Tasks;
import java.util.ArrayList;

public class K311Yfl extends Robot{
    private final static String MODEL = "K311Y-fl";
    private final static String SURFACE = "Floor";
    private final static int COST = 1000;
    private ArrayList<Tasks> capableTasks = new ArrayList<>();

    public K311Yfl() {
        super(MODEL, SURFACE, COST);
    }

    @Override
    public void setCapableTasks() {
        this.capableTasks.add(Tasks.CLEANNING);
    }

    public ArrayList<Tasks> getCapableTasks() {
        return capableTasks;
    }

}
