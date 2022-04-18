public class Request {
    private int id;
    private Client client;
    private boolean ordering;
    private String surface;
    //private TypeClean;


    public Request(int id, Client client, boolean ordering, String surface) {
        this.id = id;
        this.client = client;
        this.ordering = ordering;
        this.surface = surface;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
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
