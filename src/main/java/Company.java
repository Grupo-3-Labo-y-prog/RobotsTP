import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Company {

    private HashMap<Integer, Client> clients;
    private HashSet<Robot> robots;
    private Request request;
    private Admission admission;
    private AssignRobot assignRobot;
    private Comunication comunication;

    public void takeRequest() throws ClientNullException{
        int id = comunication.receivesId();
        if(!this.clients.containsKey(id)){
            Client clientNew = new Client();
            clientNew = comunication.receivesClient(id);
            clients.put(id, clientNew);
        }
    }

    public void processRequest() throws CantOrderingException{
        try {
            admission.validMembership(this.request);
            admission.validDebt(this.request);
            this.robots = assignRobot.assignation(this.request);
            update();
        } catch (CantOrderingException e){
            System.out.println(e.getMessage());
        }
        catch (LimitException l){
            System.out.println(l.getMessage());
        }
        catch (Exception e){
            System.out.println("Hubo un error inesperado");
        }
    }

    //done
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
