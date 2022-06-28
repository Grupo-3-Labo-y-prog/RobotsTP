package Robots;

import Entities.Request;
import Services.Tasks;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Objects;

public abstract class Robot{
    private String model;
    private String surface;
    private int cost;
    private LinkedHashSet <Request> requests;
    private ArrayList<Tasks> capableTasks;

    public Robot(String model, String surface, int cost) {
        this.model = model;
        this.surface = surface;
        this.cost = cost;
        this.requests = new LinkedHashSet<Request>();
        this.capableTasks = new ArrayList<>();
    }

    public ArrayList<Tasks> getCapableTasks() {
        return capableTasks;
    }
    public abstract void setCapableTasks();

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public LinkedHashSet<Request> getRequests() {
        return requests;
    }

    public void setRequests(LinkedHashSet<Request> requests) {
        this.requests = requests;
    }

    @Override
    public String toString() {
        return "Robots.Robot:" +
                "\n model='" + model + '\n' +
                "\n surface='" + surface + '\n' +
                "\n cost=" + cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return model.equals(robot.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model);
    }

}