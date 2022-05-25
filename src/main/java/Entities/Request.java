package Entities;

import Services.Tasks;
import Services.TypeClean;

import java.util.ArrayList;
import java.util.Iterator;

public class Request {
    private  int ID;
    private Client client;
    private ArrayList <Tasks> requestedTasks;
    private TypeClean cleaning;
    private String address;

    public Request() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Request(int ID, Client client, ArrayList<Tasks> requestedTasks, TypeClean cleaning, String address ) {
        this.ID = ID;
        this.client = client;
        this.requestedTasks = requestedTasks;
        this.cleaning = cleaning;
        this.address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<Tasks> getRequestedTasks() {
        return requestedTasks;
    }

    public void setRequestedTasks(ArrayList<Tasks> requestedTasks) {
        this.requestedTasks = requestedTasks;
    }

    public TypeClean getCleaning() {
        return cleaning;
    }

    public void setCleaning(TypeClean cleaning) {
        this.cleaning = cleaning;
    }

    public String showTask(){
        Iterator <Tasks> iterator = this.requestedTasks.iterator();
        StringBuilder message = new StringBuilder();

        while(iterator.hasNext()){

            message.append(iterator.next());
            message.append("\n");
        }
        return message.toString();
    }
    @Override
    public String toString() {
        return "Entities.Request:" +
                "\n ID=" + ID +
                "\n client=" + client +
                "\n requestedTasks=" + showTask() +
                "\n cleaning=" + cleaning +
                "\n address='" + address + '\n';
    }
}
