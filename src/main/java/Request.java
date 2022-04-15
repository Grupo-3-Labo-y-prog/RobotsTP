public class Request {
    private int id;
    private Client client;
    private boolean ordering;
    //private TypeClean;


    public Request(int id, Client client, boolean ordering) {
        this.id = id;
        this.client = client;
        this.ordering = ordering;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isOrdering() {
        return ordering;
    }

    public void setOrdering(boolean ordering) {
        this.ordering = ordering;
    }
}
