import java.text.CollationElementIterator;
import java.util.Collection;
import java.util.LinkedHashSet;

public abstract class Robot {
    private String model;
    private String surface;
    private boolean canOder;
    private boolean canShine;
    private int cost;
    private LinkedHashSet <Request> requests;

    public Robot(String model, String surface, boolean canOder, boolean canShine, int cost) {
        this.model = model;
        this.surface = surface;
        this.canOder = canOder;
        this.canShine = canShine;
        this.cost = cost;
        this.requests = new LinkedHashSet<Request>();
    }
}
