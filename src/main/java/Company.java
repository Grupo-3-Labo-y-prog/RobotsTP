import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Company {

    private HashMap<Integer, Client> clients;
    private HashSet<Robot> robots;
    private Request request;
    private Admission admission;
    private AssignRobot assignRobot;
    //private Comunation comunation;

    //hacer constructor
    //mejorar + hacer excepciones
    public void processRequest() throws CantOrderingException{
        try {
            admission.validMembership(this.request);
            admission.validDebt(this.request);
            this.robots = assignRobot.assignation(this.request);
            update();
            //comunication.showMessage("Pedido valido");
        } catch (CantOrderingException e){
            System.out.println(e.getMessage());
        }
        catch (LimitException l){
            System.out.println(l.getMessage());
        }
        catch (Exception e){ //excepcion generica
            System.out.println("Hubo un error inesperado");
        }
    }

    //done ---- falta excepciones
    public void update(){
        try{
            if(!clients.containsKey(this.request.getID())){
                throw new ClientNullException("No existe el cliente en la base");
            }
            Client cliente = this.clients.get(this.request.getClient().getId());
            if (request.getRequestedTasks().contains(Tasks.ORDERING)){
                cliente.setOrdering(cliente.getOrdering() + 1);
            }
            cliente.setCleaning(cliente.getCleaning()+1);
        } catch (ClientNullException c){
            System.out.println(c.getMessage());
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
