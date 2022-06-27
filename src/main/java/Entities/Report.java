package Entities;

import Services.Complex;
import Services.Simple;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Report {

    public String quantityPerType(HashMap<Integer, Request> requestHashMap){

        Collection<Request> requests = requestHashMap.values();

        int complex = (int) requests.stream().filter(r -> r.getTypeCleanning().getClass() == Complex.class).count();
        int simple = (int) requests.stream().filter(r -> r.getTypeCleanning().getClass() == Simple.class).count();

        // devuelve "Complex: (cantidad) vs Simple: (cantidad)"
        return "Complex: " + complex + " vs Simple: " + simple;
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
