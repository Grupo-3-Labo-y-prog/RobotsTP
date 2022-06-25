package Entities;

import Robots.Robot;
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
    private HashSet <Robot> robotsAssigned;

    @Override
    public String toString() {
        return "Request{" +
                "ID=" + ID +
                ", client=" + client +
                ", requestedTasks=" + requestedTasks +
                ", requestedServices=" + requestedServices +
                ", typeCleanning=" + typeCleanning +
                ", address='" + address + '\'' +
                ", wastes=" + wastes +
                ", pets=" + pets +
                ", lastCleanning=" + lastCleanning +
                ", price=" + price +
                '}';
    }

    public Request() {
    }

    public Request(int ID, Client client, ArrayList<Tasks> requestedTasks, ArrayList<Service> requestedServices, String address, TreeSet<Waste> wastes, int pets, LocalDate lastCleanning, float price) {
        this.ID = ID;
        this.client = client;
        this.requestedTasks = requestedTasks;
        this.requestedServices = requestedServices;
        this.typeCleanning = getTypeCleanning();
        this.address = address;
        this.wastes = wastes;
        this.pets = pets;
        this.lastCleanning = lastCleanning;
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
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

    public void setCost(float price) {
        this.price = price;
    }

    private void getCostService(){


    }

    private float getCostTypeClean() {
        return this.typeCleanning.getCost();
    }

    public HashSet<Robot>getRobotsAssigned() {
        return robotsAssigned;
    }

    public void setRobotsAssigned(HashSet<Robot> robotsAssigned) {
        this.robotsAssigned = robotsAssigned;
    }

    public Request(int ID, Client client, ArrayList<Tasks> requestedTasks, TypeClean typeCleanning, String address) {
        this.ID = ID;
        this.client = client;
        this.requestedTasks = requestedTasks;
        this.typeCleanning = typeCleanning;
        this.address = address;
    }
}