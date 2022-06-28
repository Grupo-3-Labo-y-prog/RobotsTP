package Robots;
import Services.Tasks;
import java.util.ArrayList;

public class K311Yfu extends Robot {
    private final static String MODEL = "K311Y-fu";
    private final static String SURFACE = "Furniture";
    private final static int COST = 500;
    private ArrayList<Tasks> capableTasks = new ArrayList<>();


    public K311Yfu() {
        super(MODEL,SURFACE,COST);
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
