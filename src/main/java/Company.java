import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Company {

    private HashMap<Integer, Client> clients;
    private TreeSet<Robot> robots;
    private Request request;
    private Admission admission;
    //private AssingRobot assingRobot;

    //hacer constructor
    //mejorar + hacer excepciones
    public void processRequest(){
        try {
            admission.validMembership(this.request);
            admission.validDebt(this.request.getClient());
            //admissionRequest();
            //this.robots = assingRobot();
            update(this.request.getClient());
            print(this.request);
        }catch (Exception e){ //hacer excepcion

        }
    }

    //done
    /*public void admissionRequest(){
        admission.validMembership(this.request);
        admission.validDebt(this.request.getClient());
    }*/
    //a chequear
    public TreeSet<Robot> assingRobot(){
        //this.robot = SearchRobot();
        //return robot

        return this.robots;
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
        //llama a la funcion comunicacion que hace diana
    }

    public HashMap<Integer, Client> getClients() {
        return clients;
    }

    public void setClients(HashMap<Integer, Client> clients) {
        this.clients = clients;
    }

    public TreeSet<Robot> getRobots() {
        return robots;
    }

    public void TreeSet(TreeSet<Robot> robots) {
        this.robots = robots;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
