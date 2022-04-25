import java.util.HashMap;
import java.util.HashSet;

public class Company {

    private HashMap<Integer, Client> clients;
    private HashSet<Robot> robots;
    private Robot robot;
    private Request request;
    private Admission admission;

    //hacer constructor

    public void processRequest(){

        try {

            admissionRequest();
            searchRobot();
        }catch (Exception e){ //hacer excepcion

        }
    }

    public void admissionRequest(){
        admission.validMembership(this.request);
        admission.validDebt(this.request);
    }

    public Robot searchRobot(){
        return new S031RTY();
    }

    public void update(){}

    public void print(){}

    public HashMap<Integer, Client> getClients() {
        return clients;
    }

    public void setClients(HashMap<Integer, Client> clients) {
        this.clients = clients;
    }

    public HashSet<Robot> getRobots() {
        return robots;
    }

    public void setRobots(HashSet<Robot> robots) {
        this.robots = robots;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
