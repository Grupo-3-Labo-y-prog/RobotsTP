package Bussiness;

import Comunications.Comunication;
import Entities.Client;
import Entities.Request;
import Exceptions.CantOrderingException;
import Exceptions.ClientNullException;
import Exceptions.LimitException;
import Robots.Robot;
import Services.Tasks;

import java.util.HashMap;
import java.util.HashSet;

public class Company {

    private HashMap<Integer, Client> clients;
    private HashSet<Robot> robots;
    private Request request;
    private Admission admission;
    private AssignRobot assignRobot;
    private Comunication comunication;

    public void takeRequest(){
        int id = comunication.receivesId();
        Client clientRequest = this.clients.get(id);
        if(clientRequest.equals(null)){
            clientRequest = comunication.receivesClient(id);
        }
        clients.put(clientRequest.getId(), clientRequest);
        this.request =  comunication.receivesRequest(clientRequest);
    }

    public void processRequest(){
        takeRequest();
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
