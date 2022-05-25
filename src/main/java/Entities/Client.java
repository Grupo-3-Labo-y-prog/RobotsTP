package Entities;

import Memberships.Membership;

public class Client {

    private int id;
    private Membership membership;
    private int ordering; //contador de los ordenamientos que pidio en ese mes
    private int cleaning; //contador de las limpiezas que pidio en ese mes

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

    public Client(int id, Membership membership, int ordering, int cleaning) {
        this.id = id;
        this.membership = membership;
        this.ordering = ordering;
        this.cleaning = cleaning;
    }


}
