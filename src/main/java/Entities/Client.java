package Entities;

import Memberships.Membership;

import java.util.ArrayList;

public class Client {

    private int id;
    private Membership membership;
    private int ordering; //contador de los ordenamientos que pidio en ese mes
    private int cleaning; //contador de las limpiezas que pidio en ese mes
    private ArrayList<Request> requests;

    public Client() {
    }

    public int getId() {
        return id;
    }

    public Membership getMembership() {
        return membership;
    }

    public int getOrdering() {
        return ordering;
    }

    public int getCleaning() {
        return cleaning;
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public void setOrdering(int ordering) {
        this.ordering = ordering;
    }

    public void setCleaning(int cleaning) {
        this.cleaning = cleaning;
    }

    public void setRequests(ArrayList<Request> requests) {
        this.requests = requests;
    }

    public Client(int id, Membership membership, int ordering, int cleaning, ArrayList<Request> requests) {
        this.id = id;
        this.membership = membership;
        this.ordering = ordering;
        this.cleaning = cleaning;
        this.requests = requests;
    }

    public Client(int id, Membership membership, int ordering, int cleaning) {
        this.id = id;
        this.membership = membership;
        this.ordering = ordering;
        this.cleaning = cleaning;
    }


}
