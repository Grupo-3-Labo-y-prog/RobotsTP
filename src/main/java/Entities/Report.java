package Entities;

import Services.Complex;
import Services.Simple;

import java.util.Collection;
import java.util.HashMap;

public class Report {

    public AmountOfCleaning quantityPerType(HashMap<Integer, Request> requestHashMap){

        Collection<Request> requests = requestHashMap.values();

        AmountOfCleaning types = new AmountOfCleaning();
        types.setAmountOfComplex((int) requests.stream().filter(r -> r.getTypeCleanning() !=null).filter(r -> r.getTypeCleanning().getClass() == Complex.class).count());
        types.setAmountOfSimple((int) requests.stream().filter(r -> r.getTypeCleanning() !=null).filter(r -> r.getTypeCleanning().getClass() == Simple.class).count());

        return types;
    }

    public float costPerClient(HashMap<Integer, Client> clients, int id){

        Client client = clients.get(id);

        return (float) client.getRequests().stream().mapToDouble(Request::getCost).sum();
    }

    public float costPerRequest(HashMap<Integer, Request> requests, int id){
        Request request = requests.get(id);

        return request.getCost();
    }
}
