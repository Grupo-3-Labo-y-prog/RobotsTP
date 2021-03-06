package Bussiness;

import Entities.*;
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
    private HashSet<Employee> employees;
    private Request request;
    private Admission admission;
    private AssignRobot assignRobot;

private Report report;
    public void takeRequest(){
        //a futuro cuando se utilice comunication
    }

    public void processRequest(){
        takeRequest();
        try {
            admission.validMembership(this.request);
            admission.validDebt(this.request);
            admission.setTypeClean(this.request);
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
            this.request.setRobotsAssigned(this.robots);
            this.admission.getApprovedRequests().put(this.request.getID(),this.request);
        } catch (ClientNullException c){
            System.out.println(c.getMessage());
        }

    }

    public void getTypeCleanningsQuantities() {
        AmountOfCleaning types = this.report.quantityPerType(this.admission.getApprovedRequests());
        System.out.println("Simple: " + types.getAmountOfSimple() + " vs. Complex: " + types.getAmountOfComplex());
    }

    public void getCostByClient(int id) {
        System.out.println(report.costPerClient(this.clients, id));
    }

    public void getRequestCost(int id) {
        System.out.println(report.costPerRequest(this.admission.getApprovedRequests(), id));
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

    public Company() {
    }


}
