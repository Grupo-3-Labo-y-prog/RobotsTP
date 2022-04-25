import java.util.HashMap;
import java.util.HashSet;

public class Company {

    private HashMap<Integer, Client> clients;
    private HashSet<Robot> robots;
    private Robot robot;
    private Request request;
    private Admission admission;

    //hacer constructor
    //mejorar + hacer excepciones
    public void processRequest(){

        try {
            admissionRequest();
            this.robot = searchRobot();
            update(this.request.getClient());
            print(this.request);
        }catch (Exception e){ //hacer excepcion

        }
    }

    //done
    public void admissionRequest(){
        admission.validMembership(this.request);
        admission.validDebt(this.request.getClient());
    }
    //a chequear
    public Robot searchRobot(){
        //this.robot = SearchRobot();
        //return robot

        return this.robot;
    }
    //done ---- a chequear
    public void update(Client c){
        if (clients.containsKey(c)){
            if (request.isOrdering()){
                c.setOrdering(c.getOrdering() + 1);
            }
            c.setCleaning(c.getCleaning()+1);
        }
    }
    //aclarar mensaje de salida
    public void print(Request r){
        System.out.println("El pedido de " + r.getClient().getId() + " fue admitido");
    }

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
