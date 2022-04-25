

import java.util.ArrayList;

public class Request {
    private  int ID;
    private Client client;
    private ArrayList <Tasks> requestedTasks;
    private TypeClean cleaning;

    public Request(int ID, Client client, ArrayList<Tasks> requestedTasks, TypeClean cleaning) {
        this.ID = ID;
        this.client = client;
        this.requestedTasks = requestedTasks;
        this.cleaning = cleaning;
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
}
