import java.text.CollationElementIterator;
import java.util.Collection;
import java.util.LinkedHashSet;

public abstract class Robot {
    private String model;
    private String surface;
    private boolean canOder;
    private int cost;
    private LinkedHashSet <Request> requests;

    public Robot(String model, String surface, boolean canOder, int cost) {
        this.model = model;
        this.surface = surface;
        this.canOder = canOder;
        this.cost = cost;
        this.requests = new LinkedHashSet<Request>();
    }
}
