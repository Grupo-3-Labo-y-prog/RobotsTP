package Entities;

import Services.*;

import java.time.LocalDate;
import java.time.Duration;
import java.util.*;

import static Services.Waste.MUD;

public class Request {
    private int ID;
    private Client client;
    private ArrayList<Tasks> requestedTasks;
    private ArrayList<Service> requestedServices;
    private TypeClean typeCleanning;
    private String address;

    private TreeSet<Waste> wastes;

    private int pets;

    private LocalDate lastCleanning;

    private float price;

    @Override
    public String toString() {
        return "Entities.Request:" +
                "\n ID=" + ID +
                "\n client=" + client +
                "\n requestedTasks=" + showTask() +
                "\n cleaning=" + typeCleanning +
                "\n address='" + address + '\n';
    }

    public Request() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Request(int ID, Client client, ArrayList<Tasks> requestedTasks, TypeClean cleaning, String address) {
        this.ID = ID;
        this.client = client;
        this.requestedTasks = requestedTasks;
        this.typeCleanning = cleaning;
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

    public TypeClean getTypeCleanning() {
        return typeCleanning;
    }

    public void setTypeCleanning(TypeClean typeCleanning) {
        this.typeCleanning = typeCleanning;
    }

    public String showTask() {
        Iterator<Tasks> iterator = this.requestedTasks.iterator();
        StringBuilder message = new StringBuilder();

        while (iterator.hasNext()) {

            message.append(iterator.next());
            message.append("\n");
        }
        return message.toString();
    }

    public int findDifference(LocalDate start_date, LocalDate end_date) {

        Duration diff = Duration.between(start_date.atStartOfDay(), end_date.atStartOfDay());
        return (int) diff.toDays();
    }

    public int DaysDiference() {

        LocalDate start_date = this.lastCleanning;
        LocalDate end_date = LocalDate.now();

        return findDifference(start_date, end_date);
    }

    public void setTypeClean() {

        this.typeCleanning = new Simple();

        if (DaysDiference() >= 15 || this.pets > 1 || this.wastes.contains(MUD)) {

            this.typeCleanning = new Complex();
        }

    }

    public ArrayList<Service> getRequestedServices() {
        return requestedServices;
    }

    public void setRequestedServices(ArrayList<Service> requestedServices) {
        this.requestedServices = requestedServices;
    }

    public TreeSet<Waste> getWastes() {
        return wastes;
    }

    public void setWastes(TreeSet<Waste> wastes) {
        this.wastes = wastes;
    }

    public int getPets() {
        return pets;
    }

    public void setPets(int pets) {
        this.pets = pets;
    }

    public LocalDate getLastCleanning() {
        return lastCleanning;
    }

    public void setLastCleanning(LocalDate lastCleanning) {
        this.lastCleanning = lastCleanning;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}