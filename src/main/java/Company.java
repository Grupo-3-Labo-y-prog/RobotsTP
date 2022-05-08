import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Company {

    private HashMap<Integer, Client> clients;
    private HashSet<Robot> robots;
    private Request request;
    private Admission admission;
    private AssignRobot assignRobot;

    //hacer constructor
    //mejorar + hacer excepciones
    public void processRequest(){
        try {
            admission.validMembership(this.request);
            admission.validDebt(this.request);
            this.robots = assignRobot.assignation(this.request);
            update();
            //print(this.request);
        } /*catch () excepcion de limit para el debito y otra para la membrecia y ordenar{

        }*/
        catch (Exception e){ //excepcion generica

        }
    }

    //done ---- falta excepciones
    public void update(){
        try{
            if(!clients.containsKey(this.request.getID())){
                //throw new excepcion de cliente faltante
            }
            Client cliente = this.clients.get(this.request.getClient().getId());
            if (request.getRequestedTasks().contains(Tasks.ORDERING)){
                cliente.setOrdering(cliente.getOrdering() + 1); //si cliente tiene 2 ordening, con el get los trae y le suma 1
            }
            cliente.setCleaning(cliente.getCleaning()+1);

        } catch (Exception e){

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

    public HashSet<Robot> getRobots() {
        return robots;
    }

    public void TreeSet(HashSet<Robot> robots) {
        this.robots = robots;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
