package PaymentDB;

import java.util.HashMap;

public class Payment {

    private HashMap<Integer,Debt> clients;

    public float getAmount (int ID){

        return this.clients.get((Integer) ID).getAmount();
    }

    public Payment(HashMap<Integer, Debt> clients) {
        this.clients = clients;
    }

    public HashMap<Integer, Debt> getClients() {
        return clients;
    }

    public void setClients(HashMap<Integer, Debt> clients) {
        this.clients = clients;
    }
}


